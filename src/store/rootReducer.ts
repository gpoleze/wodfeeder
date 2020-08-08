import { combineReducers } from "redux";

import appReducer, { IAppInitialState } from "views/App/App.reducer";
import workoutsReducer, { IWorkoutsInitialState } from "views/Workouts/Workouts.reducer";

export interface IState {
    themeAndSlider: IAppInitialState;
    workouts: IWorkoutsInitialState;
}

const rootReducer = combineReducers({
    themeAndSlider: appReducer,
    workouts: workoutsReducer,
});

export default rootReducer;
