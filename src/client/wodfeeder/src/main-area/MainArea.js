import React, {Component} from 'react';
import {connect} from "react-redux";
import {listWeekWorkouts} from '../logic/wod-api';
import WorkoutTable from "../component/WorkoutTable/WorkoutTable";
import {Route} from "react-router-dom";
import {Switch} from "@material-ui/core";

class MainArea extends Component {

    componentDidMount() {
        this.props.listWeeksWorkouts();
    }

    render() {
        return (<WorkoutTable {...this.props}/>);
    }
}

const mapStateToProps = state => ({workouts: state.weeksWorkouts});

const mapDispatchToProps = dispatch => {
    return {
        listWeeksWorkouts: weekNumber => dispatch(listWeekWorkouts(weekNumber))
    };
};

export default connect(mapStateToProps, mapDispatchToProps)(MainArea);
