import {applyMiddleware, combineReducers, createStore} from "redux";
import thunk from "redux-thunk";

import {weekWorkouts} from "../reducers/workouts";

const reducers = combineReducers({weeksWorkouts: weekWorkouts});
export const store = createStore(reducers, applyMiddleware(thunk));