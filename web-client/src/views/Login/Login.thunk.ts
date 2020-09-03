import { createAsyncThunk } from "@reduxjs/toolkit";

import { AuthControllerApiFactory, UserLoginForm } from "apiSpecs";
import config from "Constants";
import { IFormInputChangedPayload } from "views/Login/Login.types";

export const submitLoginThunk = createAsyncThunk<string, UserLoginForm, { rejectValue: IFormInputChangedPayload[] }>(
    "login/submitLogin",
    async (userLoginForm, { rejectWithValue }) => {
        try {
            const response = await AuthControllerApiFactory({ basePath: config.url.API_URL }).login(userLoginForm);
            return response.data.token;
        } catch (err) {
            if (err.message === "Network Error")
                return rejectWithValue([
                    {
                        field: "username",
                        value: "Unknown error, please contact the app's developer",
                    },
                ]);

            if (err.response.status === 400) {
                return rejectWithValue(
                    err.response.data.errors.map(
                        ({ field, defaultMessage }: { field: string; defaultMessage: string }) => ({
                            field,
                            value: defaultMessage,
                        }),
                    ),
                );
            }
            if (err.response.status === 403) {
                return rejectWithValue([{ field: "username", value: "Username not exist or wrong password" }]);
            }
            return rejectWithValue([
                {
                    field: "username",
                    value: "Unknown error, please contact the app's developer",
                },
            ]);
        }
    },
);
