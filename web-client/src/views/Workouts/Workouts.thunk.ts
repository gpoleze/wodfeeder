import axios from "axios";

import { WorkoutVO } from "apiSpecs";
import { workoutsLoaded } from "./Workouts.reducer";
import { Dispatch } from "react";
import { PayloadAction } from "@reduxjs/toolkit";

export const loadWorkouts = () => (dispatch: Dispatch<PayloadAction<WorkoutVO>>) => {
    axios.get<WorkoutVO[]>("/api/workouts/").then((response) => dispatch(workoutsLoaded(response.data)));
};