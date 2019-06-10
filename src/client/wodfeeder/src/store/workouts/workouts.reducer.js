import {List} from 'immutable'
import {combineReducers} from "redux";
import {
    WEEKS_WORKOUTS,
    WORKOUTS_FORM_EDIT,
    WORKOUTS_FORM_VIEW
} from "./workouts.constants";

const weekWorkouts = (state = [], action) => {
    if (action.type === WEEKS_WORKOUTS)
        return new List(action.payload);

    return state;
};

const weekFormReducer = (state = {}, action) => {
    if (action.type === WORKOUTS_FORM_VIEW)
        return action.payload;

    if (action.type === WORKOUTS_FORM_EDIT) {
        const {fieldName,fieldValue} = action.payload;
        const newState = {...state};
        newState[fieldName].fieldValue = Number(fieldValue);
        return newState;
    }
    return state;
};

export default combineReducers({
    weeksWorkouts: weekWorkouts,
    weekFormValues: weekFormReducer,
});