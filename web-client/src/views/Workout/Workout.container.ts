import { PayloadAction, ThunkDispatch } from "@reduxjs/toolkit";
import { connect } from "react-redux";

import { State } from "store/globalStates/type";
import {
    dateChanged,
    descriptionChanged,
    nameChanged,
    notesChanged,
    selectWorkoutDate,
    selectWorkoutDescription,
    selectWorkoutName,
    selectWorkoutNotes,
    selectWorkoutType,
    selectWorkoutTypes,
    typeChanged,
    WorkoutDispatchProps,
    WorkoutStateProps,
} from "views/Workout";
import { loadWorkoutTypesThunk } from "views/Workout/Workout.thunk";
import Workout from "views/Workout/Workout.view";

const mapStateToProps = (state: State): WorkoutStateProps => ({
    workoutName: selectWorkoutName(state),
    workoutDescription: selectWorkoutDescription(state),
    workoutNotes: selectWorkoutNotes(state),
    workoutDate: selectWorkoutDate(state),
    workoutType: selectWorkoutType(state),
    types: selectWorkoutTypes(state),
});

const mapDispatchToProps = (dispatch: ThunkDispatch<any, any, any>): WorkoutDispatchProps => ({
    setWorkoutName: (name: string): PayloadAction<string> => dispatch(nameChanged(name)),
    setWorkoutDescription: (description: string): PayloadAction<string> => dispatch(descriptionChanged(description)),
    setWorkoutNotes: (notes: string): PayloadAction<string> => dispatch(notesChanged(notes)),
    setWorkoutDate: (date: string): PayloadAction<string> => dispatch(dateChanged(date)),
    setWorkoutType: (type: string): PayloadAction<string> => dispatch(typeChanged(type)),
    loadWorkoutTypes: () => dispatch(loadWorkoutTypesThunk()),
});

export default connect(mapStateToProps, mapDispatchToProps)(Workout);
