import React, {Component} from "react";
import LoginForm from "../../components/login-form/login-form.index";

class Login extends Component {

    componentWillMount() {
        this.props.isSubmitButtonDisabled(this.props.username.value, this.props.password.value);
    }

    submit = (event) => {
        event.preventDefault();

        const username = this.props.username.value;
        const password = this.props.password.value;

        this.props.login(username, password);
    };

    render() {
        return (
            <LoginForm
                username={this.props.username}
                password={this.props.password}
                handleSubmit={this.submit}
                handleChange={this.props.addFormChange}
                submitButtonDisabled={this.props.submitButtonDisabled}
            />
        );
    }
}

export default Login