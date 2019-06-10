import React from 'react';
import {PropTypes} from 'prop-types';
import {FormControl, InputLabel, Select} from "@material-ui/core";

import selectInputStyles from "./select-input.style";

const SelectInput = ({name, value, options, changeHandler}) => {
    const classes = selectInputStyles();

    return (
        <FormControl className={classes.formControl}>
            <InputLabel htmlFor="name">{name}</InputLabel>
            <Select
                native
                name={name}
                id={name}
                value={value}
                onChange={event => changeHandler(event.target.value)}
                aria-describedby={name}
            >
                <option value={''} key={`${name}_empty_option`}/>
                {
                    options ?
                        options.map(option => (
                            <option
                                value={option.value}
                                key={option.value}
                                aria-describedby={option.value}
                            >
                                {option.name}
                            </option>
                        ))
                        : null
                }
            </Select>
        </FormControl>
    );
};

SelectInput.propTypes = {
    name: PropTypes.string,
    value: PropTypes.any,
    options: PropTypes.array,
    changeHandler: PropTypes.func
};

SelectInput.defaultProps = {
    name: null,
    value: '',
    options: [],
    changeHandler: event => console.info(event.target.value)
};

export default SelectInput;