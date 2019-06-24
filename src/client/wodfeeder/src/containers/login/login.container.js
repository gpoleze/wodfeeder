import {connect} from "react-redux";

import Login from "./login.page";
import {getPassword, getSubmitButtonDisabled, getUsername} from "../../store/app-bar/sign-in/login.selector";
import {addFormChange, isSubmitButtonDisabled} from "../../store/forms/forms.thunk";
import {login} from "../../store/app-bar/sign-in/login.thunk";

const mapStateToProps = state => {
    return {
        username: getUsername(state),
        password: getPassword(state),
        submitButtonDisabled: getSubmitButtonDisabled(state),
    }
};

const mapDispatchToProps = dispatch => ({
    addFormChange: (fieldName, FieldValue) => dispatch(addFormChange('loginForm', fieldName, FieldValue)),
    isSubmitButtonDisabled: () => dispatch(isSubmitButtonDisabled('loginForm')),
    login: (username, password) => dispatch(login(username, password)),
});

export default connect(mapStateToProps, mapDispatchToProps)(Login);