import React, {Component} from "react";
import SelectInput from "../forms/select-input/select-input.index";
import Input from "@material-ui/core/Input";
import {PropTypes} from "prop-types";

class WeekSelectionForm extends Component {

    handleSubmit(event) {
        event.preventDefault();

        //TODO - Finish the the action to execute the change after selecting the values
        console.log('Submiting form');
    };

    render() {
        const {week, year} = this.props;
        return (
            <form>
                <SelectInput
                    name={week.fieldName}
                    value={week.fieldValue}
                    options={week.options}
                    changeHandler={newValue => console.log('week', newValue)}
                />
                <SelectInput
                    name={year.ieldName}
                    value={year.fieldValue}
                    options={year.options}
                    changeHandler={newValue => console.log('year', newValue)}
                />
                <Input type={'submit'} onClick={this.handleSubmit} value={'Change Week'}/>
            </form>
        );
    }
}

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