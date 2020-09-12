import { PayloadAction } from "@reduxjs/toolkit";
import { connect } from "react-redux";
import { Dispatch } from "redux";

import { State } from "store/globalStates/type";
import {
    nameChanged,
    selectWorkoutName,
    WorkoutDispatchProps,
    WorkoutStateProps,
    descriptionChanged,
    selectWorkoutDescription,
    selectWorkoutNotes,
    notesChanged,
} from "views/Workout";
import Workout from "views/Workout/Workout.view";

const mapStateToProps = (state: State): WorkoutStateProps => ({
    workoutName: selectWorkoutName(state),
    workoutDescription: selectWorkoutDescription(state),
    workoutNotes: selectWorkoutNotes(state),
});

const mapDispatchToProps = (dispatch: Dispatch): WorkoutDispatchProps => ({
    setWorkoutName: (name: string): PayloadAction<string> => dispatch(nameChanged(name)),
    setWorkoutDescription: (description: string): PayloadAction<string> => dispatch(descriptionChanged(description)),
    setWorkoutNotes: (notes: string): PayloadAction<string> => dispatch(notesChanged(notes)),
});

export default connect(mapStateToProps, mapDispatchToProps)(Workout);
