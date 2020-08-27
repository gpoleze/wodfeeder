import { Dispatch } from "redux";

import { AuthControllerApiFactory, UserLoginForm } from "apiSpecs";
import { updateToken, updateLoginStatus } from "store/globalStates/reducer";

import { clearLoginFormErrors, loginFormError } from "./Login.reducer";

export const loginThunk = (username: string, password: string) => (dispatch: Dispatch) => {
    const userLoginForm: UserLoginForm = { username, password };
    AuthControllerApiFactory({})
        .login(userLoginForm)
        .then((res) => res.data)
        .then((tokenVO) => {
            dispatch(updateToken(tokenVO.token));
            dispatch(updateLoginStatus(true));
            dispatch(clearLoginFormErrors());
        })
        .catch((err) => {
            if (err.message === "Network Error") {
                dispatch(clearLoginFormErrors());
                dispatch(
                    loginFormError({ field: "username", value: "Unknown error, please contact the app's developer" }),
                );
                return;
            }

            const { status, data } = err.response;
            if (status === 400) {
                const { errors } = data;
                dispatch(clearLoginFormErrors());
                errors.forEach(({ field, defaultMessage }: { field: string; defaultMessage: string }) => {
                    dispatch(loginFormError({ field, value: defaultMessage }));
                });
                return;
            }
            if (status === 403) {
                dispatch(clearLoginFormErrors());
                dispatch(loginFormError({ field: "username", value: "Username not exist or wrong password" }));
                return;
            }
            dispatch(clearLoginFormErrors());
            dispatch(loginFormError({ field: "username", value: "Unknown error, please contact the app's developer" }));
        });
};
