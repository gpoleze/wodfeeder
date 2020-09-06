import { createSlice, PayloadAction } from "@reduxjs/toolkit";

import { submitLoginThunk } from "views/Login/Login.thunk";

export interface IGlobalState {
    isLoggedIn: boolean;
    token: string;
}

export const globalInitialState: IGlobalState = {
    isLoggedIn: false,
    token: "",
};

const updateLoginStatusReducer = (state: IGlobalState, { payload }: PayloadAction<boolean>): IGlobalState => ({
    ...state,
    isLoggedIn: payload,
});

const changeTokenReducer = (state: IGlobalState, { payload }: PayloadAction<string>): IGlobalState => ({
    ...state,
    token: payload,
});

const slice = createSlice({
    name: "global",
    initialState: globalInitialState,
    reducers: {
        // updateLoginStatus: updateLoginStatusReducer,
        updateToken: changeTokenReducer,
    },
    extraReducers: {
        [submitLoginThunk.fulfilled as any]: updateLoginStatusReducer,
    },
});

export const { updateToken } = slice.actions;

export default slice.reducer;
