import { combineReducers } from "redux";

import appReducer, { IAppInitialState } from "views/App/App.reducer";

export interface IState {
    themeAndSlider: IAppInitialState;
}

const rootReducer = combineReducers({
    themeAndSlider: appReducer,
});

export default rootReducer;
