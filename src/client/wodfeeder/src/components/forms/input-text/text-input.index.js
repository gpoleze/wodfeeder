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
        changeHandler
    }) => {
    const classes = textInputStyle();
    return (
    <FormControl className={classes.root}>
        <InputLabel htmlFor={id}>{label}</InputLabel>
        <Input
            id={id}
            aria-describedby={ariaHelperText}
            name={name}
            value={value}
            onChange={e => changeHandler(e.target.value)}
        />
    </FormControl>
)};

TextInput.propTypes = {
    id: PropTypes.string,
    label: PropTypes.string,
    ariaHelperText: PropTypes.string,
    name: PropTypes.string,
    value: PropTypes.any,
    changeHandler: PropTypes.func,
};

TextInput.defaultProps = {
    id: Date.now().toString(),
    label: 'Pass Input Label',
    ariaHelperText: 'Pass Input Label',
    name: '',
    value: '',
    changeHandler: value => console.log(value)
};

export default TextInput;