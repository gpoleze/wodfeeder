import { combineReducers } from "redux";

import globalReducers from "store/globalStates/reducer";
import appReducer from "views/App/App.reducer";
import loginFormReducer from "views/Login/Login.reducer";
import { reducer as workoutReducer } from "views/Workout";
import workoutsReducer from "views/Workouts/Workouts.reducer";

const rootReducer = combineReducers({
    themeAndSlider: appReducer,
    workouts: workoutsReducer,
    workout: workoutReducer,
    login: loginFormReducer,
    global: globalReducers,
});

export default rootReducer;
