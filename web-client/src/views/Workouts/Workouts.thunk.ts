import { Dispatch } from "react";

import { PayloadAction } from "@reduxjs/toolkit";
import axios from "axios";

import { WorkoutVO } from "apiSpecs";
import config from "Constants";

import { workoutsLoaded } from "./Workouts.reducer";

export const loadWorkouts = () => (dispatch: Dispatch<PayloadAction<WorkoutVO>>) => {
    axios.get<WorkoutVO[]>(`${config.url.API_URL}/api/workouts/`).then((response) => dispatch(workoutsLoaded(response.data)));
};