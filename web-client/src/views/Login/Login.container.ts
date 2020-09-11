import { connect } from "react-redux";
import { ThunkDispatch } from "redux-thunk";

import { selectIsLoggedIn } from "store/globalStates/selector";
import { State } from "store/globalStates/type";
import { selectErrors, selectPassword, selectUsername } from "views/Login/Login.selector";
import { submitLoginThunk } from "views/Login/Login.thunk";

import { formInputChanged } from "./Login.reducer";
import Login, { ILoginDispatchProps, ILoginStateProps } from "./Login.view";

const mapStateToProps = (state: State): ILoginStateProps => ({
    isLoggedIn: selectIsLoggedIn(state),
    redirect_uri: "/",
    username: selectUsername(state),
    password: selectPassword(state),
    errors: selectErrors(state),
});
const mapDispatchToProps = (dispacth: ThunkDispatch<any, any, any>): ILoginDispatchProps => ({
    handleSubmit: (username: string, password: string) => dispacth(submitLoginThunk({ username, password })),
    handleFormChange: (field, value) => dispacth(formInputChanged({ field, value })),
});

export default connect(mapStateToProps, mapDispatchToProps)(Login);
