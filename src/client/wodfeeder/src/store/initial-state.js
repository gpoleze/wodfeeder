import {workoutsInitialState} from "./workouts/workouts.initial-state";
import {loginForminitialState} from "./app-bar/sign-in/login.initial-state";

export const initialState = {
    ...workoutsInitialState,
    forms:{
        ...workoutsInitialState.forms,
        ...loginForminitialState
    }
};