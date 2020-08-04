import React from "react";

import Container from "@material-ui/core/Container";
import Grid from "@material-ui/core/Grid";

import DisplayBox from "components/DisplayBox";

import useStyles from "./Workouts.styles";

const Workouts: React.FC = () => {
    const classes = useStyles();
    return (
        <Container maxWidth="lg" className={classes.container}>
            <Grid container spacing={3}>
                {["a", "b", "c", "d"].map((el) => (
                    <Grid item xs={12} md={8} lg={9} key={el}>
                        <DisplayBox>
                            <div>{el}</div>
                        </DisplayBox>
                    </Grid>
                ))}
            </Grid>
        </Container>
    );
};

export default Workouts;
