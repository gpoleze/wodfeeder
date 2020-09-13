import { CaseReducer, createSlice, PayloadAction } from "@reduxjs/toolkit";
import moment from "moment";

import { WorkoutTypeVO } from "apiSpecs/api";

import { WorkoutState } from "./Workout.types";

export const WorkoutInitialState: WorkoutState = {
    name: "",
    date: moment().format("yyyy-MM-DD"),
    type: "",
    scoreType: "",
    description: "",
    notes: "",
    types: [],
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

export const typeChangedReducer: CaseReducer<WorkoutState, PayloadAction<string>> = (draft, { payload }) => {
    draft.type = payload.trim();
    return draft;
};

export const typesLoadedReducer: CaseReducer<WorkoutState, PayloadAction<WorkoutTypeVO[]>> = (draft, { payload }) => {
    draft.types = payload;
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
        typeChanged: typeChangedReducer,
        typesLoaded: typesLoadedReducer,
    },
});

export const {
    nameChanged,
    descriptionChanged,
    notesChanged,
    dateChanged,
    typeChanged,
    typesLoaded,
} = WorkoutSlice.actions;

export const { reducer } = WorkoutSlice;
