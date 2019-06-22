import React from 'react';
import {Button, Paper} from "@material-ui/core";

import TextInput from "../forms/input-text/text-input.index";
import loginFormStyle from "./login-form.style";

const LoginForm = (
    {
        username,
        password,
        changeHandler,
        submitHandler,
        submitButtonDisabled
    }) => {

    const handleSubmit = (event) => {
        event.preventDefault();
        submitHandler(username.fieldValue, password.fieldValue);
    };

    const classes = loginFormStyle();
    return (
        <Paper elevation={2} className={classes.paper}>
            <form method={'POST'} className={classes.form}>
                <div className={classes.inputGroup}>
                    <TextInput
                        id={username.id}
                        label={username.label}
                        value={username.fieldValue}
                        ariaHelperText={username.ariaHelperText}
                        name={username.name}
                        changeHandler={(value => changeHandler('username', value))}
                    />
                </div>
                <div className={classes.inputGroup}>
                    <TextInput
                        id={password.id}
                        label={password.label}
                        value={password.fieldValue}
                        ariaHelperText={password.ariaHelperText}
                        name={password.name}
                        changeHandler={(value => changeHandler('password', value))}
                    />
                </div>
                <Button
                    variant="contained"
                    onClick={handleSubmit}
                    className={classes.button}
                    color={'default'}
                    disabled={submitButtonDisabled}
                    fullWidth={true}
                >
                    Submit
                </Button>
            </form>
        </Paper>
    );

};

export default LoginForm;