import { Action, CaseReducer, createSlice, Draft, PayloadAction } from "@reduxjs/toolkit";
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

export const changeStringObject = (
    draft: Draft<WorkoutState>,
    name: keyof WorkoutState,
    value: string,
): Draft<WorkoutState> => {
    draft[name] = value.trim();
    return draft;
};

export const nameChangedReducer: CaseReducer<WorkoutState, PayloadAction<string>> = (draft, { payload }) => {
    return changeStringObject(draft, "name", payload);
};

export const descriptionChangedReducer: CaseReducer<WorkoutState, PayloadAction<string>> = (draft, { payload }) => {
    return changeStringObject(draft, "description", payload);
};

export const notesChangedReducer: CaseReducer<WorkoutState, PayloadAction<string>> = (draft, { payload }) => {
    return changeStringObject(draft, "notes", payload);
};

export const dateChangedReducer: CaseReducer<WorkoutState, PayloadAction<string>> = (draft, { payload }) => {
    return changeStringObject(draft, "date", payload);
};

export const typeChangedReducer: CaseReducer<WorkoutState, PayloadAction<string>> = (draft, { payload }) => {
    return changeStringObject(draft, "type", payload);
};

export const scoringChangedReducer: CaseReducer<WorkoutState, PayloadAction<string>> = (draft, { payload }) => {
    return changeStringObject(draft, "scoring", payload);
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

export const cancelButtonReducer: CaseReducer<WorkoutState, Action<string>> = (draft) => {
    draft.name = "";
    draft.date = moment().format("yyyy-MM-DD");
    draft.type = "";
    draft.scoring = "";
    draft.description = "";
    draft.notes = "";
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
        cancelButtonAction: cancelButtonReducer,
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
    cancelButtonAction,
} = WorkoutSlice.actions;

export const { reducer } = WorkoutSlice;
