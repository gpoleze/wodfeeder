import {List} from 'immutable'
import {combineReducers} from "redux";
import {TRANSITION_STATE, WEEKS_WORKOUTS, WORKOUTS_FORM_EDIT, WORKOUTS_FORM_VIEW} from "./workouts.constants";
import {initialState} from "./initial-state";

const weekWorkouts = (state = [], action) => {
    if (action.type === WEEKS_WORKOUTS)
        return new List(action.payload);

    return state;
};

const transitionReducer = (state = initialState, action) => {
    if (action.type === TRANSITION_STATE) {
        const newState = {...state};
        Object.keys(action.payload).forEach(key => newState[key] = action.payload[key]);
        return newState;
    }
    return state;
};

const weekFormReducer = (state = {}, action) => {
    if (action.type === WORKOUTS_FORM_VIEW)
        return action.payload;

    if (action.type === WORKOUTS_FORM_EDIT) {
        const {fieldName, fieldValue} = action.payload;
        const newState = {...state};
        newState[fieldName].fieldName = fieldName;
        newState[fieldName].fieldValue = Number(fieldValue);
        return newState;
    }
    return state;
};

export default combineReducers({
    transition: transitionReducer,
    weeksWorkouts: weekWorkouts,
    weekFormValues: weekFormReducer,
});