import { createSlice } from "@reduxjs/toolkit";

export interface IAppInitialState {
    darkMode: boolean;
    isSlideOpen: boolean;
    isLoggedIn: boolean;
}

export const AppInitialState = { darkMode: true, isSlideOpen: false, isLoggedIn: false };

const AppSlice = createSlice({
    name: "app",
    initialState: AppInitialState,
    reducers: {
        toggleTheme: (state: IAppInitialState): IAppInitialState => ({ ...state, darkMode: !state.darkMode }),
        toggleSlide: (state: IAppInitialState): IAppInitialState => ({ ...state, isSlideOpen: !state.isSlideOpen }),
        toggleLogin: (state: IAppInitialState): IAppInitialState => ({ ...state, isLoggedIn: !state.isLoggedIn }),
    },
});

export const { toggleTheme, toggleSlide, toggleLogin } = AppSlice.actions;

export default AppSlice.reducer;
