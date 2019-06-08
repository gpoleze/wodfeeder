import React from 'react';
import {Select} from "@material-ui/core";
import {PropTypes} from 'prop-types';

const SelectInput = ({name, value, options, changeHandler}) => (
    <Select
        native
        name={name}
        value={value}
        onChange={event => changeHandler(event.target.value)}
    >
        {
            options ?
            options.map(option => (
                <option
                    value={option.value}
                    key={option.value}
                >
                    {option.name}
                </option>
            ))
                : null
        }
    </Select>
);

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