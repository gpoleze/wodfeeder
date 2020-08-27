import { combineReducers } from "redux";

import globalReducers, { IGlobalState } from "store/globalStates/reducer";
import appReducer, { IAppInitialState } from "views/App/App.reducer";
import loginFormReducer from "views/Login/Login.reducer";
import { ILoginFormState } from "views/Login/Login.types";
import workoutsReducer, { IWorkoutsInitialState } from "views/Workouts/Workouts.reducer";

export interface IState {
    themeAndSlider: IAppInitialState;
    workouts: IWorkoutsInitialState;
    login: ILoginFormState;
    global: IGlobalState;
}

const rootReducer = combineReducers({
    themeAndSlider: appReducer,
    workouts: workoutsReducer,
    login: loginFormReducer,
    global: globalReducers,
});

export default rootReducer;
