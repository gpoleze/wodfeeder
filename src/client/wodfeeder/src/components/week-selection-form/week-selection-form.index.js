import React from "react";
import SelectInput from "../forms/select-input/select-input.index";
import Input from "@material-ui/core/Input";
import {PropTypes} from "prop-types";

import './week-selection-form.style';
import weekSelectionFormStyles from "./week-selection-form.style";

const WeekSelectionForm = ({week, year}) => {

    const handleSubmit = (event) => {
        event.preventDefault();

        //TODO - Finish the the action to execute the change after selecting the values
        console.log('Submiting form');
    };

    const classes = weekSelectionFormStyles();

    return (
        <div className={classes.formContainer}>
        <form className={classes.form}>
            <SelectInput
                name={week.fieldName}
                value={week.fieldValue}
                options={week.options}
                changeHandler={newValue => console.log('week', newValue)}
                className={'selectInput'}
            />
            <SelectInput
                name={year.fieldName}
                value={year.fieldValue}
                options={year.options}
                changeHandler={newValue => console.log('year', newValue)}
                className={'selectInput'}
            />
            <Input type={'submit'} onClick={handleSubmit} value={'Change Week'} className={'buttonInput'}/>
        </form>
        </div>
    );

};

WeekSelectionForm.propTypes = {
    week: PropTypes.shape({
        name: PropTypes.string,
        value: PropTypes.any,
        options: PropTypes.array,
    }),
    year: PropTypes.shape({
        name: PropTypes.string,
        value: PropTypes.any,
        options: PropTypes.array,
    }),
    changeHandler: PropTypes.func
};

WeekSelectionForm.defaultProps = {
    week: {
        name: null,
        value: '',
        options: []
    },
    year: {
        name: null,
        value: '',
        options: []
    },
};

export default WeekSelectionForm;