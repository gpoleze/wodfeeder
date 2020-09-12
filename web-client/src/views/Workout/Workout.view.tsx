import React, { useState } from "react";

import Button from "@material-ui/core/Button";
import Grid from "@material-ui/core/Grid";
import Paper from "@material-ui/core/Paper";
import { ClassNameMap } from "@material-ui/core/styles/withStyles";
import Typography from "@material-ui/core/Typography";

import CustomNativeDateInput from "components/CustomNativeDateInput";
import CustomNativeSelect, { SelectOption } from "components/CustomNativeSelect";
import CustomTextInput from "components/CustomTextArea";
import CustomTextArea from "components/CustomTextInput";

import useStyles from "./Workout.styles";
import { WorkoutProps } from "./Workout.types";

const menuItems: SelectOption<string>[] = [
    { name: "Warm Up", value: "warm_up", key: "warm_up" },
    { name: "WOD", value: "wod", key: "wod" },
];

const scoreItems: SelectOption<string>[] = [
    { name: "AMRAP", value: "amrap", key: "amrap" },
    { name: "RFT", value: "rft", key: "rft" },
];

const Header: React.FC = () => (
    <Typography variant="h6" align="center">
        Create New Workout
    </Typography>
);

const WorkoutName: React.FC<{
    classes: ClassNameMap;
    workoutName: string;
    setWorkoutName: (value: string) => void;
}> = ({ classes, workoutName, setWorkoutName }) => (
    <div className={classes.formControl}>
        <CustomTextInput id="workoutName" onChange={setWorkoutName} label="Name" defaultValue={workoutName} required />
    </div>
);

const WorkoutType: React.FC<{
    classes: ClassNameMap;
    workoutType: string;
    setWorkoutType: (value: string) => void;
    options: SelectOption<string>[];
}> = ({ classes, workoutType, setWorkoutType, options }) => (
    <div className={classes.formControl}>
        <CustomNativeSelect
            id="workoutType"
            onChange={setWorkoutType}
            label="Type"
            options={options}
            value={workoutType}
            required
        />
    </div>
);

const WorkoutScore: React.FC<{
    classes: ClassNameMap;
    workoutScore: string;
    setWorkoutScore: (value: string) => void;
    options: SelectOption<string>[];
}> = ({ classes, workoutScore, setWorkoutScore, options }) => (
    <div className={classes.formControl}>
        <CustomNativeSelect
            id="workoutScore"
            onChange={setWorkoutScore}
            label="Score Type"
            options={options}
            value={workoutScore}
            required
        />
    </div>
);

const WorkoutDate: React.FC<{
    classes: ClassNameMap;
    workoutDate: string | undefined;
    setWorkoutDate: (value: string) => void;
}> = ({ classes, workoutDate, setWorkoutDate }) => (
    <div className={classes.formControl}>
        <CustomNativeDateInput id="workoutDate" label="Date" value={workoutDate} onChange={setWorkoutDate} required />
    </div>
);

const WorkoutDescription: React.FC<{
    classes: ClassNameMap;
    workoutDescription: string;
    setWorkoutDescription: (value: string) => void;
}> = ({ classes, workoutDescription, setWorkoutDescription }) => (
    <div className={classes.formControl}>
        <CustomTextArea
            id="workoutDescription"
            label="Workout"
            defaultValue={workoutDescription}
            onChange={setWorkoutDescription}
            required
            rows={10}
        />
    </div>
);

const WorkoutObservations: React.FC<{
    classes: ClassNameMap;
    workoutObservations: string;
    setWorkoutObservations: (value: string) => void;
}> = ({ classes, workoutObservations, setWorkoutObservations }) => (
    <div className={classes.formControl}>
        <CustomTextArea
            id="workoutObservation"
            label="Observations"
            defaultValue={workoutObservations}
            onChange={setWorkoutObservations}
            rows={1}
        />
    </div>
);

const WorkoutButtons: React.FC<{
    classes: ClassNameMap;
    saveButtonHandler: (event: React.MouseEvent<HTMLButtonElement, MouseEvent>) => void;
    cancelButtonHandler: (event: React.MouseEvent<HTMLButtonElement, MouseEvent>) => void;
}> = ({ classes, saveButtonHandler, cancelButtonHandler }) => (
    <div className={classes.formControl}>
        <Grid container direction="row" justify="center" alignItems="center" spacing={3}>
            <Grid item xs={6}>
                <Button type="submit" variant="contained" color="secondary" onClick={cancelButtonHandler} fullWidth>
                    Cancel
                </Button>
            </Grid>
            <Grid item xs={6}>
                <Button type="submit" variant="contained" color="primary" onClick={saveButtonHandler} fullWidth>
                    Save
                </Button>
            </Grid>
        </Grid>
    </div>
);

const Workout: React.FC<WorkoutProps> = ({
    workoutName,
    setWorkoutName,
    workoutDescription,
    setWorkoutDescription,
}) => {
    const [workoutType, setWorkoutType] = useState<string>("");
    const [workoutScore, setWorkoutScore] = useState<string>("");
    const [workoutDate, setWorkoutDate] = useState<string>();
    const [workoutObservations, setWorkoutObservations] = useState<string>("");

    const classes = useStyles();
    return (
        <Paper className={classes.paper}>
            <Header />
            <form>
                <WorkoutName classes={classes} workoutName={workoutName} setWorkoutName={setWorkoutName} />
                <WorkoutDate classes={classes} workoutDate={workoutDate} setWorkoutDate={setWorkoutDate} />
                <WorkoutType
                    classes={classes}
                    workoutType={workoutType}
                    setWorkoutType={setWorkoutType}
                    options={menuItems}
                />
                <WorkoutScore
                    classes={classes}
                    workoutScore={workoutScore}
                    setWorkoutScore={setWorkoutScore}
                    options={scoreItems}
                />
                <WorkoutDescription
                    classes={classes}
                    workoutDescription={workoutDescription}
                    setWorkoutDescription={setWorkoutDescription}
                />
                <WorkoutObservations
                    classes={classes}
                    workoutObservations={workoutObservations}
                    setWorkoutObservations={setWorkoutObservations}
                />
                <WorkoutButtons
                    classes={classes}
                    saveButtonHandler={() => console.log("Clicked Save")}
                    cancelButtonHandler={() => console.log("Clicked Cancel")}
                />
            </form>
        </Paper>
    );
};

export default Workout;
