import React, {Component} from "react";
import WorkoutTable from "../../components/workout-table/workout-table.index";

export default class Workouts extends Component {

    componentDidMount() {
        this.props.listWeeksWorkouts();
    }

    render() {
        return (<WorkoutTable {...this.props}/>);
    }
}