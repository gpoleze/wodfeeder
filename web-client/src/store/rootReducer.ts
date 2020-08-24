import { combineReducers } from "redux";

import appReducer, { IAppInitialState } from "views/App/App.reducer";
import loginFormReducer, { ILoginFormState } from "views/Login/Login.reducer";
import workoutsReducer, { IWorkoutsInitialState } from "views/Workouts/Workouts.reducer";
import globalReducers, { IGlobalState } from "store/globalStates/reducer";

export interface IState {
    themeAndSlider: IAppInitialState;
    workouts: IWorkoutsInitialState;
    login: ILoginFormState;
    global: IGlobalState;
}

const rootReducer = combineReducers({
    themeAndSlider: appReducer,
    workouts: workoutsReducer,
    loginForm: loginFormReducer,
    global: globalReducers,
});

export default rootReducer;
