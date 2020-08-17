import React, { useEffect } from "react";

import Container from "@material-ui/core/Container";
import Grid from "@material-ui/core/Grid";

import DisplayBox from "components/DisplayBox";

import useStyles from "./Workouts.styles";
import { WorkoutVO } from "apiSpecs";

export interface IWorkoutsProps {
    workouts: WorkoutVO[];
    loadWorkouts: () => void;
}

const Workouts: React.FC<IWorkoutsProps> = ({ workouts, loadWorkouts }) => {
    const classes = useStyles();

    useEffect(() => {
        loadWorkouts();
    }, [loadWorkouts]);

    return (
        <Container maxWidth="lg" className={classes.container}>
            <Grid container spacing={3}>
                {workouts.map((workout) => (
                    <Grid item xs={12} md={8} lg={9} key={workout.id}>
                        <DisplayBox>
                            <div>{workout.date}</div>
                            <div>{workout.type}</div>
                            <div>{workout.exercise}</div>
                            {workout.notes ? <div>{workout.notes}</div> : ""}
                        </DisplayBox>
                    </Grid>
                ))}
            </Grid>
        </Container>
    );
};

export default Workouts;
