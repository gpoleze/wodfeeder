import { IState } from "store/rootReducer";

export const selectIsLoggedIn = (state: IState): boolean => state.global.isLoggedIn;
export const selectToken = (state: IState): string => state.global.token;
