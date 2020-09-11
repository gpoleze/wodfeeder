import { CaseReducer, createSlice, PayloadAction } from "@reduxjs/toolkit";
import moment from "moment";

import { WorkoutState } from "./Workout.types";

const WorkoutInicialState: WorkoutState = {
    name: "",
    date: moment().format("yyyy-MM-DD"),
    type: "",
    scoreType: "",
    workout: "",
    observations: "",
};

const nameChangedReducer: CaseReducer<WorkoutState, PayloadAction<string>> = (draft, { payload }) => {
    draft.name = payload;
    return draft;
};

const WorkoutSlice = createSlice({
    name: "workout",
    initialState: WorkoutInicialState,
    reducers: {
        nameChanged: nameChangedReducer,
    },
});

export const { nameChanged } = WorkoutSlice.actions;

export const { reducer } = WorkoutSlice;
