import {applyMiddleware, combineReducers, createStore} from "redux";
import thunk from "redux-thunk";
import {composeWithDevTools} from "redux-devtools-extension/developmentOnly";

import workoutsReducers from "./workouts/workouts.reducer.js";
import {initialState} from "./workouts/initial-state";

const reducers = combineReducers({
    workouts: workoutsReducers
});

export const store = createStore(
    reducers,
    initialState,
    composeWithDevTools(applyMiddleware(thunk))
);