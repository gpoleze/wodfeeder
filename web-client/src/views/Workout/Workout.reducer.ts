import { CaseReducer, createSlice, PayloadAction } from "@reduxjs/toolkit";
import moment from "moment";

import { WorkoutState } from "./Workout.types";

export const WorkoutInitialState: WorkoutState = {
    name: "",
    date: moment().format("yyyy-MM-DD"),
    type: "",
    scoreType: "",
    description: "",
    notes: "",
};

export const nameChangedReducer: CaseReducer<WorkoutState, PayloadAction<string>> = (draft, { payload }) => {
    draft.name = payload.trim();
    return draft;
};

export const descriptionChangedReducer: CaseReducer<WorkoutState, PayloadAction<string>> = (draft, { payload }) => {
    draft.description = payload.trim();
    return draft;
};

export const notesChangedReducer: CaseReducer<WorkoutState, PayloadAction<string>> = (draft, { payload }) => {
    draft.notes = payload.trim();
    return draft;
};

export const dateChangedReducer: CaseReducer<WorkoutState, PayloadAction<string>> = (draft, { payload }) => {
    draft.date = payload.trim();
    return draft;
};

const WorkoutSlice = createSlice({
    name: "workout",
    initialState: WorkoutInitialState,
    reducers: {
        nameChanged: nameChangedReducer,
        descriptionChanged: descriptionChangedReducer,
        notesChanged: notesChangedReducer,
        dateChanged: dateChangedReducer,
    },
});

export const { nameChanged, descriptionChanged, notesChanged, dateChanged } = WorkoutSlice.actions;

export const { reducer } = WorkoutSlice;
