/* eslint-disable no-param-reassign,@typescript-eslint/ban-ts-comment */
import { CaseReducer, createSlice, Draft, PayloadAction } from "@reduxjs/toolkit";

import { submitLoginThunk } from "views/Login/Login.thunk";
import { IFormInputChangedPayload, ILoginFormState } from "views/Login/Login.types";

export const LoginFormInitialState: ILoginFormState = {
    username: "",
    password: "",
    errors: {
        username: [],
        password: [],
    },
};

export const formInputChangedReducer: CaseReducer<ILoginFormState, PayloadAction<IFormInputChangedPayload>> = (
    draft: Draft<ILoginFormState>,
    { payload: { field, value } },
): ILoginFormState => {
    // @ts-ignore
    draft[field] = value;

    return draft;
};

export const loginFormErrorReducer = (
    draft: Draft<ILoginFormState>,
    { payload: { field, value } }: PayloadAction<IFormInputChangedPayload>,
): ILoginFormState => {
    if (value === "") {
        // @ts-ignore
        draft.errors[field] = [];
        return draft;
    }
    // @ts-ignore
    if (!draft.errors[field].includes(value)) {
        // @ts-ignore
        draft.errors[field].push(value);
    }

    return draft;
};

export const clearLoginFormErrorsReducer = (draft: Draft<ILoginFormState>): ILoginFormState => {
    draft.errors.username = [];
    draft.errors.password = [];
    return draft;
};

const submitLoginThunkRejectedReducer: CaseReducer<ILoginFormState, PayloadAction<IFormInputChangedPayload[]>> = (
    draft,
    { type, payload },
) => {
    clearLoginFormErrorsReducer(draft);
    payload.forEach((error) => loginFormErrorReducer(draft, { type, payload: error }));
};

const FormLoginSlice = createSlice({
    name: "formLogin",
    initialState: LoginFormInitialState,
    reducers: {
        formInputChanged: formInputChangedReducer,
    },
    extraReducers: {
        [submitLoginThunk.rejected as any]: submitLoginThunkRejectedReducer,
    },
});

export const { formInputChanged } = FormLoginSlice.actions;

export default FormLoginSlice.reducer;
