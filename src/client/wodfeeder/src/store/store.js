import {applyMiddleware, combineReducers, createStore} from 'redux';
import thunk from 'redux-thunk';
import {composeWithDevTools} from 'redux-devtools-extension/developmentOnly';

import workoutsReducers from './workouts/workouts.reducer.js';
import formsReducer from './forms/forms.reducer.js';
import {workoutsInitialState} from './workouts/workouts.initial-state';

const reducers = combineReducers({
    workouts: workoutsReducers,
    forms: formsReducer
});

const initialState = {
    ...workoutsInitialState,
};

export const store = createStore(
    reducers,
    initialState,
    composeWithDevTools(applyMiddleware(thunk))
);