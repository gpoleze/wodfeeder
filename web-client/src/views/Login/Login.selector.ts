import { IState } from "store/rootReducer";
import { ILoginFormErrors } from "views/Login/Login.types";

export const selectUsername = (state: IState): string => state.login.username;
export const selectPassword = (state: IState): string => state.login.password;
export const selectErrors = (state: IState): ILoginFormErrors => state.login.errors;
