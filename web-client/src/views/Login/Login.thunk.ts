import { Dispatch } from "redux";
import { AuthControllerApiFactory, UserLoginForm } from "apiSpecs";
import { updateToken, updateLoginStatus } from "store/globalStates/reducer";

export const loginThunk = (username: string, password: string) => (dispatch: Dispatch) => {
    const userLoginForm: UserLoginForm = { username, password };
    AuthControllerApiFactory({})
        .login(userLoginForm)
        .then((res) => res.data)
        .then((tokenVO) => {
            dispatch(updateToken(tokenVO.token));
            dispatch(updateLoginStatus(true));
        })
        .catch((err) => {
            console.log(err.response.status);
            console.log(err.response.data);
        });
};
