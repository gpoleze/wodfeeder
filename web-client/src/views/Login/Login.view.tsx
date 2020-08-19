import React from "react";

import Button from "@material-ui/core/Button";
import Divider from "@material-ui/core/Divider";
import TextField from "@material-ui/core/TextField";

import GoogleLoginButton from "components/GoogleLoginButton/GoogleLoginButton";

import useStyles from "./Login.styles";

export interface ILoginProps {
    isLoggedIn: boolean;
    redirect_uri: string;
    error?: {
        username: boolean;
    };
    handleSubmit: () => void;
}

const Login: React.FC<ILoginProps> = ({
    isLoggedIn,
    redirect_uri,
    error = { username: false },
    handleSubmit = () => {
        console.log("you're logging in!!");
    },
}) => {
    const classes = useStyles();

    const submitHandler = (event: React.MouseEvent) => {
        event.preventDefault();
        handleSubmit();
    };

    const keyPressHandler = (event: React.KeyboardEvent) => {
        if (event.keyCode === 13) handleSubmit();
    };

    return (
        <div className={classes.root}>
            <GoogleLoginButton
                isLoggedIn={isLoggedIn}
                redirect_uri={window.location.href}
                className={classes.boxItem}
            />
            <Divider />
            <form autoComplete="off">
                <TextField
                    className={classes.item}
                    id="username"
                    label="Username"
                    variant="outlined"
                    helperText={error.username ? "Username must be an email" : ""}
                    error={error.username}
                    required
                    fullWidth
                />
                <TextField
                    className={classes.item}
                    id="outlined-basic"
                    label="Password"
                    variant="outlined"
                    type="password"
                    required
                    fullWidth
                />
                <Button
                    type="submit"
                    variant="contained"
                    color="primary"
                    className={classes.button}
                    onClick={submitHandler}
                    onKeyPress={keyPressHandler}
                >
                    Login
                </Button>
            </form>
        </div>
    );
};

export default Login;
