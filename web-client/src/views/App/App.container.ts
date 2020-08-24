import { connect } from "react-redux";
import { ThunkDispatch } from "redux-thunk";

import { selectIsLoggedIn } from "store/globalStates/selector";
import { IState } from "store/rootReducer";

import { toggleSlide, toggleTheme } from "./App.reducer";
import App, { IAppDispatchProps, IAppStateProps } from "./App.view";

const mapStateToProps = (state: IState): IAppStateProps => ({
    darkTheme: state.themeAndSlider.darkMode,
    slideOpen: state.themeAndSlider.isSlideOpen,
    isLoggedIn: selectIsLoggedIn(state),
});
const mapDispatchToProps = (dispatch: ThunkDispatch<any, any, any>): IAppDispatchProps => ({
    toggleTheme: () => dispatch(toggleTheme()),
    toggleSlide: () => dispatch(toggleSlide()),
});

export default connect(mapStateToProps, mapDispatchToProps)(App);
