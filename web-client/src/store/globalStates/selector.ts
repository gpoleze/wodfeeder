import { State } from "./type";

export const selectIsLoggedIn = (state: State): boolean => state.global.isLoggedIn;
export const selectToken = (state: State): string => state.global.token;
