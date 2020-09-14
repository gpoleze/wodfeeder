import { AsyncThunkAction, PayloadAction, ThunkDispatch } from "@reduxjs/toolkit";
import { connect } from "react-redux";

import { WorkoutScoringVO, WorkoutTypeVO } from "apiSpecs";
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
    selectWorkoutScoring,
    selectWorkoutScorings,
    selectWorkoutType,
    selectWorkoutTypes,
    typeChanged,
    WorkoutDispatchProps,
    WorkoutStateProps,
    scoringChanged,
} from "views/Workout";
import { loadWorkoutScoringsThunk, loadWorkoutTypesThunk } from "views/Workout/Workout.thunk";
import Workout from "views/Workout/Workout.view";

const mapStateToProps = (state: State): WorkoutStateProps => ({
    workoutName: selectWorkoutName(state),
    workoutDescription: selectWorkoutDescription(state),
    workoutNotes: selectWorkoutNotes(state),
    workoutDate: selectWorkoutDate(state),
    workoutType: selectWorkoutType(state),
    workoutScoring: selectWorkoutScoring(state),
    types: selectWorkoutTypes(state),
    scorings: selectWorkoutScorings(state),
});

const mapDispatchToProps = (dispatch: ThunkDispatch<State, any, any>): WorkoutDispatchProps => ({
    setWorkoutName: (name: string): PayloadAction<string> => dispatch(nameChanged(name)),
    setWorkoutDescription: (description: string): PayloadAction<string> => dispatch(descriptionChanged(description)),
    setWorkoutNotes: (notes: string): PayloadAction<string> => dispatch(notesChanged(notes)),
    setWorkoutDate: (date: string): PayloadAction<string> => dispatch(dateChanged(date)),
    setWorkoutType: (type: string): PayloadAction<string> => dispatch(typeChanged(type)),
    setWorkoutScoring: (scoring: string): PayloadAction<string> => dispatch(scoringChanged(scoring)),
    loadWorkoutTypes: (): AsyncThunkAction<WorkoutTypeVO[], never, { rejectValue: string }> =>
        dispatch(loadWorkoutTypesThunk()),
    loadWorkoutScorings: (): AsyncThunkAction<WorkoutScoringVO[], never, { rejectValue: string }> =>
        dispatch(loadWorkoutScoringsThunk()),
});

export default connect(mapStateToProps, mapDispatchToProps)(Workout);
