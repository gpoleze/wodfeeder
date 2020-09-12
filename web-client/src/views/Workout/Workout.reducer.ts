import { CaseReducer, createSlice, PayloadAction } from "@reduxjs/toolkit";
import moment from "moment";

import { WorkoutState } from "./Workout.types";

export const WorkoutInitialState: WorkoutState = {
    name: "",
    date: moment().format("yyyy-MM-DD"),
    type: "",
    scoreType: "",
    description: "",
    observations: "",
};

export const nameChangedReducer: CaseReducer<WorkoutState, PayloadAction<string>> = (draft, { payload }) => {
    draft.name = payload.trim();
    return draft;
};

export const descriptionChangedReducer: CaseReducer<WorkoutState, PayloadAction<string>> = (draft, { payload }) => {
    draft.description = payload.trim();
    return draft;
};

const WorkoutSlice = createSlice({
    name: "workout",
    initialState: WorkoutInitialState,
    reducers: {
        nameChanged: nameChangedReducer,
        descriptionChanged: descriptionChangedReducer,
    },
});

export const { nameChanged, descriptionChanged } = WorkoutSlice.actions;

export const { reducer } = WorkoutSlice;
