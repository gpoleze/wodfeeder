import React from "react";
import SelectInput from "../forms/select-input/select-input.index";
import Input from "@material-ui/core/Input";
import {PropTypes} from "prop-types";

import './week-selection-form.style';
import weekSelectionFormStyles from "./week-selection-form.style";

const WeekSelectionForm = ({week, year, changeHandler, submitHandler}) => {

    const handleSubmit = (event) => {
        event.preventDefault();

        // console.log(week.fieldValue,year.fieldValue);
        submitHandler(week.fieldValue,year.fieldValue);
    };

    const classes = weekSelectionFormStyles();

    return (
        <div className={classes.formContainer}>
            <form className={classes.form}>
                <SelectInput
                    name={week.fieldName}
                    value={week.fieldValue}
                    options={week.options}
                    changeHandler={newValue => changeHandler('week', newValue)}
                    className={'selectInput'}
                />
                <SelectInput
                    name={year.fieldName}
                    value={year.fieldValue}
                    options={year.options}
                    changeHandler={newValue => changeHandler('year', newValue)}
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
    changeHandler: PropTypes.func,
    submitHandler: PropTypes.func
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