import {FORM_EDIT, FORM_VIEW, SUBMIT_BUTTON} from "./forms.constants";
import {initialState} from "../initial-state";
import {InputVO} from "../../components/forms/InputVO";

const formsReducer = (state = initialState.forms, action) => {
    if (action.type === FORM_VIEW) {
        return action.payload;
    }

    if (action.type === FORM_EDIT) {

        const {form, inputVo, newValue} = action.payload;
        console.log(newValue);

        const newState = {...state};
        newState[form][inputVo.name] = InputVO.copy(inputVo, {value: newValue});

        return newState;
    }


    if (action.type === SUBMIT_BUTTON) {
        const form = action.payload;

        const newState = {...state};

        newState[form].submitButtonDisabled = !Object
            .keys(state[form])
            .filter(key => key !== 'submitButtonDisabled')
            .map(key => String(state[form][key].value).trim())
            .every(value => !!value);

        return newState;
    }

    return state;
};

export default formsReducer;