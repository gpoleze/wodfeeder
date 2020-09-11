import { State } from "store/globalStates/type";
import { ILoginFormErrors } from "views/Login/Login.types";

export const selectUsername = (state: State): string => state.login.username;
export const selectPassword = (state: State): string => state.login.password;
export const selectErrors = (state: State): ILoginFormErrors => state.login.errors;
