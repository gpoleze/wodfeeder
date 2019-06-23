import React from "react";
import {FormControl, Input, InputLabel} from "@material-ui/core";
import {PropTypes} from "prop-types";

import textInputStyle from './text-input.style'

const TextInput = (
    {
        id,
        label,
        ariaHelperText,
        name,
        value,
        type,
        changeHandler
    }) => {

    const classes = textInputStyle();
    return (
        <FormControl className={classes.root}>
            <InputLabel htmlFor={id}>{label}</InputLabel>
            <Input
                id={id}
                type={type}
                aria-describedby={ariaHelperText}
                name={name}
                value={value}
                onChange={event => changeHandler(event.target.value)}
            />
        </FormControl>
    )
};

TextInput.propTypes = {
    id: PropTypes.string,
    label: PropTypes.string,
    type: PropTypes.string,
    ariaHelperText: PropTypes.string,
    name: PropTypes.string,
    value: PropTypes.any,
    changeHandler: PropTypes.func,
};

export default TextInput;