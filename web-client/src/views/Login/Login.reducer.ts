import { createSlice, PayloadAction } from "@reduxjs/toolkit";

export interface ILoginFormState {
    username: string;
    password: string;
}

export const LoginFormInitialState: ILoginFormState = {
    username: "",
    password: "",
};

const usernameChangedReducer = (state: ILoginFormState, action: PayloadAction<string>): ILoginFormState => ({
    ...state,
    username: action.payload,
});

const passwordChangedReducer = (state: ILoginFormState, action: PayloadAction<string>): ILoginFormState => ({
    ...state,
    password: action.payload,
});

const FormLoginSlice = createSlice({
    name: "fromLogin",
    initialState: LoginFormInitialState,
    reducers: {
        usernameChanged: usernameChangedReducer,
        passwordChanged: passwordChangedReducer,
    },
});

export const { usernameChanged, passwordChanged } = FormLoginSlice.actions;

export default FormLoginSlice.reducer;
