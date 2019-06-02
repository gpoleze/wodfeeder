import React from 'react';
import {Table, TableBody, TableCell, TableHead, TableRow} from "@material-ui/core";

const WorkoutTable = props => {
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
                        props.workouts.map(
                            workout => (
                                <TableRow key={`${workout.id}_${workout.date}`}>
                                    {/*<TableRow key={workout.date}>*/}
                                    <TableCell align="left">
                                        {`${workout.date.year}-${workout.date.month}-${workout.date.day}`}
                                    </TableCell>
                                    <TableCell align="left">{workout.exercises}</TableCell>
                                </TableRow>)
                        )
                    }
                </TableBody>
            </Table>
        );
};

export default WorkoutTable;