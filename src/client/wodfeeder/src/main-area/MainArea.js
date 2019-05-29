import React, {Component} from 'react';
import {Table, TableBody, TableCell, TableHead, TableRow} from '@material-ui/core';
import {connect} from "react-redux";
import {listWeekWorkouts} from '../logic/wod-api';

class MainArea extends Component {

    componentDidMount() {
        this.props.listWeeksWorkouts();
    }

    toFormatedDate = date => `${date.year}-${date.month}-${date.day}`;

    render() {
        console.log(this.props.workouts);
        return (
            <Table>
                <TableHead>
                    <TableRow>
                        <TableCell>Date</TableCell>
                        <TableCell align="left">Exercises</TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {
                        this.props.workouts.map(workout => (
                            <TableRow key={this.toFormatedDate(workout.date)}>
                                <TableCell align="left">{this.toFormatedDate(workout.date)}</TableCell>
                                <TableCell align="left">{workout.exercises}</TableCell>
                            </TableRow>
                        ))
                    }
                </TableBody>
            </Table>
        );
    }
}

const mapStateToProps = state => ({workouts: state.weeksWorkouts});

const mapDispatchToProps = dispatch => {
    return {
        listWeeksWorkouts: weekNumber => dispatch(listWeekWorkouts(weekNumber))
    };
};

export default connect(mapStateToProps, mapDispatchToProps)(MainArea);
