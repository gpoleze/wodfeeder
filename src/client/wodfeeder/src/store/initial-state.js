import {workoutsInitialState} from "./workouts/workouts.initial-state";
import {loginFormInitialState} from "./app-bar/sign-in/login.initial-state";

export const initialState = {
    ...workoutsInitialState,
    forms:{
        ...workoutsInitialState.forms,
        ...loginFormInitialState
    }
};