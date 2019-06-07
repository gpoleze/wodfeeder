import {applyMiddleware, combineReducers, createStore} from "redux";
import thunk from "redux-thunk";

import {weekWorkouts} from "./workouts/workouts.reducer.js";

const reducers = combineReducers({weeksWorkouts: weekWorkouts});
export const store = createStore(reducers, applyMiddleware(thunk));