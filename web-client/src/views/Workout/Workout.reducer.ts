import { CaseReducer, createSlice, PayloadAction } from "@reduxjs/toolkit";
import moment from "moment";

import { WorkoutScoringVO, WorkoutTypeVO } from "apiSpecs/api";
import { loadWorkoutScoringsThunk, loadWorkoutTypesThunk } from "views/Workout/Workout.thunk";

import { WorkoutState } from "./Workout.types";

export const WorkoutInitialState: WorkoutState = {
    name: "",
    date: moment().format("yyyy-MM-DD"),
    type: "",
    scoring: "",
    description: "",
    notes: "",
    types: [],
    scorings: [],
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

export const scoringChangedReducer: CaseReducer<WorkoutState, PayloadAction<string>> = (draft, { payload }) => {
    draft.scoring = payload.trim();
    return draft;
};

export const typesLoadedReducer: CaseReducer<WorkoutState, PayloadAction<WorkoutTypeVO[]>> = (draft, { payload }) => {
    draft.types = payload;
    return draft;
};

export const scoringsLoadedReducer: CaseReducer<WorkoutState, PayloadAction<WorkoutScoringVO[]>> = (
    draft,
    { payload },
) => {
    draft.scorings = payload;
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
        scoringChanged: scoringChangedReducer,
    },
    extraReducers: {
        [loadWorkoutTypesThunk.fulfilled as any]: typesLoadedReducer,
        [loadWorkoutScoringsThunk.fulfilled as any]: scoringsLoadedReducer,
    },
});

export const {
    nameChanged,
    descriptionChanged,
    notesChanged,
    dateChanged,
    typeChanged,
    scoringChanged,
} = WorkoutSlice.actions;

export const { reducer } = WorkoutSlice;
