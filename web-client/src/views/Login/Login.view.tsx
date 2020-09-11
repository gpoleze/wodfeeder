import React, { ChangeEvent } from "react";

import Button from "@material-ui/core/Button";
import TextField from "@material-ui/core/TextField";
import _reduce from "lodash/reduce";
import { Redirect } from "react-router-dom";

import useInputDebounce from "utils/hook/useInputDebounce";
import { ILoginFormErrors } from "views/Login/Login.types";

import useStyles from "./Login.styles";

export interface ILoginStateProps {
    isLoggedIn: boolean;
    redirect_uri?: string;
    errors: ILoginFormErrors;
    username: string;
    password: string;
}

export interface ILoginDispatchProps {
    handleSubmit: (username: string, password: string) => void;
    handleFormChange: (field: string, value: string) => void;
}

export interface ILoginProps extends ILoginStateProps, ILoginDispatchProps {}

// eslint-disable-next-line max-lines-per-function
const Login: React.FC<ILoginProps> = ({
    username,
    password,
    isLoggedIn,
    redirect_uri = "/",
    errors,
    handleSubmit,
    handleFormChange,
}) => {
    const classes = useStyles();

    const submitHandler = (event: React.MouseEvent): void => {
        event.preventDefault();
        handleSubmit(username, password);
    };

    return (
        <div className={classes.root}>
            {isLoggedIn ? <Redirect to={redirect_uri} /> : ""}
            {/* <GoogleLoginButton */}
            {/*    isLoggedIn={isLoggedIn} */}
            {/*    redirect_uri={window.location.href} */}
            {/*    className={classes.boxItem} */}
            {/* /> */}
            {/* <Divider /> */}
            <form autoComplete="off" className={classes.boxItem}>
                <TextField
                    className={classes.item}
                    id="username"
                    label="Username"
                    variant="outlined"
                    helperText={
                        errors.username.length !== 0
                            ? _reduce(errors.username, (prev, curr) => `${prev}\n${curr}`, "")
                            : ""
                    }
                    error={errors.username.length !== 0}
                    required
                    fullWidth
                    onChange={useInputDebounce((e: ChangeEvent<HTMLInputElement>) =>
                        handleFormChange("username", e.target.value),
                    )}
                />
                <TextField
                    className={classes.item}
                    id="outlined-basic"
                    label="Password"
                    variant="outlined"
                    type="password"
                    helperText={
                        errors.password.length !== 0
                            ? _reduce(errors.password, (prev, curr) => `${prev}\n${curr}`, "")
                            : ""
                    }
                    error={errors.password.length !== 0}
                    required
                    fullWidth
                    onChange={useInputDebounce((e: ChangeEvent<HTMLInputElement>) =>
                        handleFormChange("password", e.target.value),
                    )}
                />
                <Button
                    type="submit"
                    variant="contained"
                    color="primary"
                    className={classes.button}
                    onClick={submitHandler}
                    fullWidth
                >
                    Login
                </Button>
            </form>
        </div>
    );
};

export default Login;
