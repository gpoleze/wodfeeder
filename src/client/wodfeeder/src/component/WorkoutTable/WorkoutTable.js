import React from 'react';
import {Table, TableBody, TableCell, TableHead, TableRow} from "@material-ui/core";
import './WokoutTable.styles.css'

const WorkoutTable = props => {
    return !props.workouts ?
        null :
        (
            <Table data-test="table">
                <TableHead>
                    <TableRow>
                        <TableCell>Date</TableCell>
                        <TableCell align="left">Exercises</TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {
                        props.workouts.map(
                            workout => (
                                <TableRow key={`${workout.id}_${workout.date}`} data-test='row'>
                                    <TableCell align="left" className="date" data-test='date'>
                                        {`${workout.date.year}-${workout.date.month}-${workout.date.day}`}
                                    </TableCell>
                                    <TableCell align="left" data-test='exercise'>{workout.exercises}</TableCell>
                                </TableRow>)
                        )
                    }
                </TableBody>
            </Table>
        );
};

export default WorkoutTable;