import {applyMiddleware, combineReducers, createStore} from "redux";
import thunk from "redux-thunk";

import {
    weekWorkouts,
    weekFormReducer
} from "./workouts/workouts.reducer.js";

const reducers = combineReducers({
    weeksWorkouts: weekWorkouts,
    weekFormValues: weekFormReducer,
});
export const store = createStore(reducers, applyMiddleware(thunk));