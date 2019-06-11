import React from 'react';
import {Paper, Table, TableBody, TableCell, TableHead, TableRow} from "@material-ui/core";
import './workout-table.styles.css'
import Fade from "@material-ui/core/Fade";

const WorkoutTable = ({workouts, transition}) => {
    return !workouts ?
        null :
        (
            <Fade direction={transition.direction} in={transition.checked} >
                <Paper elevation={2} className={'paper'}>
                    <Table data-test="table">
                        <TableHead>
                            <TableRow>
                                <TableCell>Date</TableCell>
                                <TableCell align="left">Exercises</TableCell>
                            </TableRow>
                        </TableHead>
                        <TableBody>
                            {
                                workouts.map(
                                    workout => (
                                        <TableRow key={`${workout.id}_${workout.date}`} data-test='row'>
                                            <TableCell align="left" className="date" data-test='date'>
                                                {workout.date}
                                            </TableCell>
                                            <TableCell align="left" data-test='exercise'>
                                                {workout.exercises}
                                            </TableCell>
                                        </TableRow>
                                    )
                                )
                            }
                        </TableBody>
                    </Table>
                </Paper>
            </Fade>
        );
};

export default WorkoutTable;