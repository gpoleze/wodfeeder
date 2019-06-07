import React, {Component} from "react";
import SelectInput from "../forms/select-input/select-input.index";
import Input from "@material-ui/core/Input";

class WeekSelectionForm extends Component {

    handleSubmit(event) {
        event.preventDefault();
        console.log('Submiting form');
    };

    render() {
        console.log(this.props);
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

export default WeekSelectionForm;