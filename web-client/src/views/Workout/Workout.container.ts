import { PayloadAction } from "@reduxjs/toolkit";
import { connect } from "react-redux";
import { Dispatch } from "redux";

import { State } from "store/globalStates/type";
import Workout from "views/Workout/Workout.view";

import { nameChanged, selectWorkoutName, WorkoutDispatchProps, WorkoutStateProps } from ".";

const mapStateToProps = (state: State): WorkoutStateProps => ({
    workoutName: selectWorkoutName(state),
});

const mapDispatchToProps = (dispatch: Dispatch): WorkoutDispatchProps => ({
    setWorkoutName: (name: string): PayloadAction<string> => dispatch(nameChanged(name)),
});

export default connect(mapStateToProps, mapDispatchToProps)(Workout);
