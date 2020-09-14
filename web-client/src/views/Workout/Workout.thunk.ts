import { createAsyncThunk } from "@reduxjs/toolkit";

import {
    WorkoutScoringControllerApiFactory,
    WorkoutScoringVO,
    WorkoutTypeControllerApiFactory,
    WorkoutTypeVO
} from "apiSpecs";
import config from "Constants";

const basePath = config.url.API_URL;

export const loadWorkoutTypesThunk = createAsyncThunk<WorkoutTypeVO[], never, { rejectValue: string }>(
    "workouts/loadTypes",
    async (arg, { rejectWithValue }) => {
        const api = WorkoutTypeControllerApiFactory({ basePath });
        try {
            const axiosPromise = await api.workoutTypes();
            return axiosPromise.data;
        } catch (err) {
            return rejectWithValue("Unknown error, please contact the app's developer");
        }
    },
);

export const loadWorkoutScoringsThunk = createAsyncThunk<WorkoutScoringVO[], never, { rejectValue: string }>(
    "workouts/loadScorings",
    async (arg, { rejectWithValue }) => {
        const api = WorkoutScoringControllerApiFactory({ basePath });
        try {
            const axiosPromise = await api.workoutScorings();
            return axiosPromise.data;
        } catch (err) {
            return rejectWithValue("Unknown error, please contact the app's developer");
        }
    },
);
