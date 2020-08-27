import { connect } from "react-redux";
import { ThunkDispatch } from "redux-thunk";

import { selectIsLoggedIn } from "store/globalStates/selector";
import { IState } from "store/rootReducer";
import { selectErrors, selectPassword, selectUsername } from "views/Login/Login.selector";
import { loginThunk } from "views/Login/Login.thunk";

import Login, { ILoginDispatchProps, ILoginStateProps } from "./Login.view";
import { formInputChanged } from "./Login.reducer";

const mapStateToProps = (state: IState): ILoginStateProps => ({
    isLoggedIn: selectIsLoggedIn(state),
    redirect_uri: "/",
    username: selectUsername(state),
    password: selectPassword(state),
    errors: selectErrors(state),
});
const mapDispatchToProps = (dispacth: ThunkDispatch<any, any, any>): ILoginDispatchProps => ({
    handleSubmit: (username: string, password: string) => dispacth(loginThunk(username, password)),
    handleFormChange: (field, value) => dispacth(formInputChanged({ field, value })),
});

export default connect(mapStateToProps, mapDispatchToProps)(Login);
