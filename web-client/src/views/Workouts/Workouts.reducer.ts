import { CaseReducer, createSlice, PayloadAction, SliceCaseReducers } from "@reduxjs/toolkit";

import { WorkoutVO } from "apiSpecs";

export interface IWorkoutsInitialState {
    workouts: WorkoutVO[];
}

const workoutsInitialState: IWorkoutsInitialState = {
    workouts: [],
};

const workoutsLoadedCaseReducer: CaseReducer<IWorkoutsInitialState, PayloadAction<WorkoutVO[]>> = (state, action) => ({
    ...state,
    workouts: action.payload,
});

const WorkoutsSlice = createSlice<IWorkoutsInitialState, SliceCaseReducers<IWorkoutsInitialState>>({
    name: "workouts",
    initialState: workoutsInitialState,
    reducers: {
        workoutsLoaded: workoutsLoadedCaseReducer,
    },
});

export const { workoutsLoaded } = WorkoutsSlice.actions;

export default WorkoutsSlice.reducer;
