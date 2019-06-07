import React, {Component} from "react";
import WorkoutTable from "../../components/workout-table/workout-table.index";
import WeekSelectionForm from "../../components/week-selection-form/week-selection-form.index";

export default class Workouts extends Component {

    componentDidMount() {
        this.props.listWeeksWorkouts();
    }

    render() {
        const fakeProps = {
            week: {
                fieldName: 'week',
                fieldValue: 23,
                options: [...Array(52).keys()].map(key => ({name: key + 1, value: key + 1}))
            },
            year: {
                ieldName: 'year',
                fieldValue: 2019,
                options: [
                    {name: 2018, value: 2018},
                    {name: 2019, value: 2019},
                ]
            }
        };

        return (
            <div>
                <WeekSelectionForm {...fakeProps}/>
                <WorkoutTable {...this.props}/>
            </div>
        );
    }
}