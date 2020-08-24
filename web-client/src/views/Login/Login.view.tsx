import React, { useState } from "react";

import Button from "@material-ui/core/Button";
import Divider from "@material-ui/core/Divider";
import TextField from "@material-ui/core/TextField";
import { Redirect } from "react-router";

import GoogleLoginButton from "components/GoogleLoginButton/GoogleLoginButton";
import useInputDebounce from "utils/hook/useInputDebounce";

import useStyles from "./Login.styles";

export interface ILoginStateProps {
    isLoggedIn: boolean;
    redirect_uri?: string;
    error?: {
        username: boolean;
    };
}

export interface ILoginDispatchProps {
    handleSubmit: (username: string, password: string) => void;
}

export interface ILoginProps extends ILoginStateProps, ILoginDispatchProps {}

const Login: React.FC<ILoginProps> = ({
    isLoggedIn,
    redirect_uri = "/",
    error = { username: false },
    handleSubmit,
}) => {
    const classes = useStyles();
    const [password, setPassword] = useState("");
    const [username, setUsername] = useState("");

    const submitHandler = (event: React.MouseEvent): void => {
        event.preventDefault();
        handleSubmit(username, password);
    };

    const handleUsername = (event: React.ChangeEvent<HTMLInputElement>): void => {
        setUsername(event.target.value);
    };

    const handlePassword = (event: React.ChangeEvent<HTMLInputElement>): void => {
        setPassword(event.target.value);
    };

    return (
        <div className={classes.root}>
            {isLoggedIn ? <Redirect to={redirect_uri} /> : ""}
            <GoogleLoginButton
                isLoggedIn={isLoggedIn}
                redirect_uri={window.location.href}
                className={classes.boxItem}
            />
            <Divider />
            <form autoComplete="off" className={classes.boxItem}>
                <TextField
                    className={classes.item}
                    id="username"
                    label="Username"
                    variant="outlined"
                    helperText={error.username ? "Username must be an email" : ""}
                    error={error.username}
                    required
                    fullWidth
                    onChange={useInputDebounce(handleUsername)}
                />
                <TextField
                    className={classes.item}
                    id="outlined-basic"
                    label="Password"
                    variant="outlined"
                    type="password"
                    required
                    fullWidth
                    onChange={useInputDebounce(handlePassword)}
                />
                <Button
                    type="submit"
                    variant="contained"
                    color="primary"
                    className={classes.button}
                    onClick={submitHandler}
                >
                    Login
                </Button>
            </form>
        </div>
    );
};

export default Login;
