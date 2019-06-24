import React from 'react';
import {Button, Paper} from "@material-ui/core";

import TextInput from "../forms/input-text/text-input.index";
import loginFormStyle from "./login-form.style";
import {InputVO} from "../forms/InputVO";

const LoginForm = (
    {
        username,
        password,
        handleChange,
        handleSubmit,
        submitButtonDisabled
    }) => {
    const classes = loginFormStyle();
    return (
        <Paper elevation={2} className={classes.paper}>
            <form method={'POST'} className={classes.form} onSubmit={handleSubmit}>
                <div className={classes.inputGroup}>
                    <TextInput inputVo={InputVO.copy(username, {
                        changeHandler: newValue => handleChange(username, newValue)
                    })}/>
                </div>
                <div className={classes.inputGroup}>
                    <TextInput inputVo={InputVO.copy(password, {
                        changeHandler: newValue => handleChange(password, newValue)
                    })}/>
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