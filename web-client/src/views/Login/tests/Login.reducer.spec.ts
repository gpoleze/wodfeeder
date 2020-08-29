import { PayloadAction } from "@reduxjs/toolkit";

import {
    clearLoginFormErrorsReducer,
    formInputChangedReducer,
    loginFormErrorReducer,
    LoginFormInitialState,
} from "views/Login/Login.reducer";
import { ILoginFormState, IFormInputChangedPayload } from "views/Login/Login.types";

// eslint-disable-next-line max-lines-per-function
describe("Login.reducer", () => {
    describe("formInputChanged", () => {
        it.each`
            initialValue | value
            ${""}        | ${"a"}
            ${""}        | ${""}
            ${"     "}   | ${""}
            ${"a"}       | ${""}
            ${"a"}       | ${"aa"}
        `(
            "should select the username field and change its value from $initialValue to $value",
            ({ initialValue, value }: { initialValue: string; value: string }) => {
                const field = "username";

                const initialState: ILoginFormState = LoginFormInitialState;
                initialState.username = initialValue;

                const action: PayloadAction<IFormInputChangedPayload> = { payload: { field, value }, type: "" };

                const newState = formInputChangedReducer(initialState, action);

                expect(newState).toEqual({ ...initialState, username: value });
            },
        );

        it.each`
            initialValue | value
            ${""}        | ${"a"}
            ${""}        | ${""}
            ${"a"}       | ${""}
            ${"a"}       | ${"aa"}
        `(
            "should select the password field and change its value from $initialValue to $value",
            ({ initialValue, value }: { initialValue: string; value: string }) => {
                const field = "password";
                const initialState: ILoginFormState = LoginFormInitialState;
                initialState.password = initialValue;

                const action: PayloadAction<IFormInputChangedPayload> = { payload: { field, value }, type: "" };

                const newState = formInputChangedReducer(initialState, action);

                expect(newState).toEqual({ ...initialState, password: value });
            },
        );
    });

    describe("loginFormError", () => {
        it.each`
            initialValue   | value   | expected
            ${[]}          | ${"a"}  | ${["a"]}
            ${["a"]}       | ${"a"}  | ${["a"]}
            ${["a"]}       | ${"aa"} | ${["a", "aa"]}
            ${[]}          | ${""}   | ${[]}
            ${["a"]}       | ${""}   | ${[]}
            ${["a", "aa"]} | ${""}   | ${[]}
        `(
            "should select the username field and change its value from $initialValue to $expected",
            ({ initialValue, value, expected }: { initialValue: string[]; value: string; expected: string[] }) => {
                const field = "username";

                const initialState: ILoginFormState = LoginFormInitialState;
                initialState.errors.username = initialValue;

                const action: PayloadAction<IFormInputChangedPayload> = { payload: { field, value }, type: "" };

                const newState = loginFormErrorReducer(initialState, action);

                expect(newState).toEqual({
                    ...initialState,
                    errors: { ...initialState.errors, username: expected },
                });
            },
        );
        describe("clearLoginFormErrorsReducer", () => {
            it.each`
                username      | password
                ${[""]}       | ${[""]}
                ${["a"]}      | ${[""]}
                ${["a"]}      | ${["b"]}
                ${["a", "b"]} | ${[""]}
                ${["a", "b"]} | ${["c"]}
                ${[""]}       | ${["a"]}
                ${[""]}       | ${["a", "b"]}
                ${["c"]}      | ${["a", "b"]}
                ${["a", "b"]} | ${["c", "d"]}
            `(
                "should clear the errors when username is $username and password is $password",
                ({ username, password }: { username: string[]; password: string[] }) => {
                    const initialState: ILoginFormState = LoginFormInitialState;
                    initialState.errors.username = username;
                    initialState.errors.password = password;

                    const newState: ILoginFormState = clearLoginFormErrorsReducer(initialState);

                    expect(newState.errors.username).toHaveLength(0);
                    expect(newState.errors.password).toHaveLength(0);
                },
            );
        });
    });
});
