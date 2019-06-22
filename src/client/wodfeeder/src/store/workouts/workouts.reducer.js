import {List} from 'immutable'
import {combineReducers} from "redux";
import {TRANSITION_STATE, WEEKS_WORKOUTS} from "./workouts.constants";
import {workoutsInitialState} from "./workouts.initial-state";

const weekWorkouts = (state = [], action) => {
    if (action.type === WEEKS_WORKOUTS)
        return new List(action.payload);

    return state;
};

const transitionReducer = (state = workoutsInitialState, action) => {
    if (action.type === TRANSITION_STATE) {
        const newState = {...state};
        Object.keys(action.payload).forEach(key => newState[key] = action.payload[key]);
        return newState;
    }
    return state;
};

export default combineReducers({
    transition: transitionReducer,
    weeksWorkouts: weekWorkouts,
});