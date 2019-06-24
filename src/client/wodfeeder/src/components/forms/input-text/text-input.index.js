import React from "react";
import {FormControl, Input, InputLabel} from "@material-ui/core";
import {PropTypes} from "prop-types";

import textInputStyle from './text-input.style'
import {InputVO} from "../InputVO";

const TextInput = ({inputVo}) => {
    const classes = textInputStyle();
    return (
        <FormControl className={classes.root}>
            <InputLabel htmlFor={inputVo.id}>{inputVo.label}</InputLabel>
            <Input
                id={inputVo.id}
                type={inputVo.type}
                aria-describedby={inputVo.ariaHelperText}
                name={inputVo.name}
                value={inputVo.value}
                onChange={event => inputVo.changeHandler(event.target.value)}
            />
        </FormControl>
    )
};

TextInput.propTypes = {
    inputVo: PropTypes.instanceOf(InputVO)
};

export default TextInput;