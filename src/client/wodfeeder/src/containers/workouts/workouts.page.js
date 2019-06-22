import React, {Component} from "react";
import WorkoutTable from "../../components/workout-table/workout-table.index";
import WeekSelectionForm from "../../components/week-selection-form/week-selection-form.index";

export default class Workouts extends Component {

    componentWillMount() {
        this.props.listWeeksWorkouts();
        this.props.getWorkoutFormAttributes()
    }

    render() {
        return (
            <div>
                <WeekSelectionForm
                    {...this.props.workoutsFormValues}
                    changeHandler={this.props.addFormChange}
                    submitHandler={this.props.listWeeksWorkouts}
                />
                <WorkoutTable {...this.props}/>
            </div>
        );
    }
}