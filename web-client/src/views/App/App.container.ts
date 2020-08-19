import { connect } from "react-redux";
import { ThunkDispatch } from "redux-thunk";

import { IState } from "store/rootReducer";

import { toggleTheme, toggleSlide, toggleLogin } from "./App.reducer";
import App from "./App.view";

const mapStateToProps = (state: IState) => ({
    darkTheme: state.themeAndSlider.darkMode,
    slideOpen: state.themeAndSlider.isSlideOpen,
    isLoggedIn: state.themeAndSlider.isLoggedIn,
});
const mapDispatchToProps = (dispatch: ThunkDispatch<any, any, any>) => ({
    toggleTheme: () => dispatch(toggleTheme()),
    toggleSlide: () => dispatch(toggleSlide()),
    toggleLogin: () => dispatch(toggleLogin()),
});

export default connect(mapStateToProps, mapDispatchToProps)(App);
