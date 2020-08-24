import { connect } from "react-redux";
import { ThunkDispatch } from "redux-thunk";

import { IState } from "store/rootReducer";
import { loginThunk } from "views/Login/Login.thunk";

import Login, { ILoginDispatchProps, ILoginStateProps } from "./Login.view";
import { selectIsLoggedIn } from "store/globalStates/selector";

const mapStateToProps = (state: IState): ILoginStateProps => ({
    isLoggedIn: selectIsLoggedIn(state),
    redirect_uri: "/",
});
const mapDispatchToProps = (dispacth: ThunkDispatch<any, any, any>): ILoginDispatchProps => ({
    handleSubmit: (username: string, password: string) => dispacth(loginThunk(username, password)),
});

export default connect(mapStateToProps, mapDispatchToProps)(Login);
