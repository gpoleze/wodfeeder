import React, {Component} from 'react';
import {connect} from "react-redux";
import {listWeekWorkouts} from '../logic/wod-api';
import WorkoutTableIndex from "../components/workout-table/workout-table.index";

class WorkoutsIndex extends Component {

    componentDidMount() {
        this.props.listWeeksWorkouts();
    }

    render() {
        return (<WorkoutTableIndex {...this.props}/>);
    }
}

const mapStateToProps = state => ({workouts: state.weeksWorkouts});

const mapDispatchToProps = dispatch => {
    return {
        listWeeksWorkouts: weekNumber => dispatch(listWeekWorkouts(weekNumber))
    };
};

export default connect(mapStateToProps, mapDispatchToProps)(WorkoutsIndex);
