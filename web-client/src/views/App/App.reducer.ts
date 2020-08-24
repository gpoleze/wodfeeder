import { createSlice } from "@reduxjs/toolkit";

export interface IAppInitialState {
    darkMode: boolean;
    isSlideOpen: boolean;
}

export const AppInitialState = { darkMode: true, isSlideOpen: false };

const AppSlice = createSlice({
    name: "app",
    initialState: AppInitialState,
    reducers: {
        toggleTheme: (state: IAppInitialState): IAppInitialState => ({ ...state, darkMode: !state.darkMode }),
        toggleSlide: (state: IAppInitialState): IAppInitialState => ({ ...state, isSlideOpen: !state.isSlideOpen }),
    },
});

export const { toggleTheme, toggleSlide } = AppSlice.actions;

export default AppSlice.reducer;
