import React, { useState } from "react";

import { Typography } from "@material-ui/core";
import Paper from "@material-ui/core/Paper";

import CustomNativeDateInput from "components/CustomNativeDateInput";
import CustomNativeSelect from "components/CustomNativeSelect";
import CustomTextInput from "components/CustomTextInput";

import useStyles from "./Workout.styles";

export interface WorkoutProps {}
export interface WorkoutType {
    name: string;
    value: string;
    key: string;
}

const menuItems: WorkoutType[] = [
    { name: "Warm Up", value: "warm_up", key: "warm_up" },
    { name: "WOD", value: "wod", key: "wod" },
];

const Workout: React.FC<WorkoutProps> = () => {
    const [workoutType, setWorkoutType] = useState<string>();
    const [workoutDate, setWorkoutDate] = useState<string>("");
    const [workoutName, setWorkoutName] = useState<string>("");

    const classes = useStyles();
    return (
        <Paper className={classes.paper}>
            <Typography variant="h6" align="center">
                Create New Workout
            </Typography>
            <form>
                <div className={classes.formControl}>
                    <CustomTextInput id="workoutName" onChange={setWorkoutName} label="Name" value={workoutName} />
                </div>
                <div className={classes.formControl}>
                    <CustomNativeSelect
                        id="workoutType"
                        onChange={setWorkoutType}
                        label="Type"
                        options={menuItems}
                        value={workoutType}
                        required
                    />
                </div>
                <div className={classes.formControl}>
                    <CustomNativeDateInput
                        id="workoutDate"
                        label="Date"
                        value={workoutDate}
                        onChange={setWorkoutDate}
                        required
                    />
                </div>
            </form>
        </Paper>
    );
};

export default Workout;
