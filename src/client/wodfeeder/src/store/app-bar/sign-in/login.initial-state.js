import {InputVO} from "../../../components/forms/InputVO";

export const loginForminitialState = {
    loginForm: {
        username: new InputVO('username', 'Username', 'username', value => console.log(value)),
        password: new InputVO('password', 'Password', 'password', value => console.log(value), 'password'),
        submitButtonDisabled: true,
    }
};