import {List} from 'immutable'
import {WEEKS_WORKOUTS, WORKOUTS_FORM_EDIT} from "./workouts.constants";
import {combineReducers} from "redux";

const weekWorkouts = (state = [], action) => {
    if (action.type === WEEKS_WORKOUTS)
        return new List(action.payload);

    return state;
};

const weekFormReducer = (state = {}, action) => {
    if (action.type === WORKOUTS_FORM_EDIT)
        return action.payload;

    return state;
};

export default combineReducers({
    weeksWorkouts: weekWorkouts,
    weekFormValues: weekFormReducer,
});