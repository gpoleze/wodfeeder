import {FORM_EDIT, FORM_VIEW} from "./forms.constants";

const formsReducer = (state = {}, action) => {
    if (action.type === FORM_VIEW) {
        return action.payload;
    }

    if (action.type === FORM_EDIT) {
        const {form, fieldName, fieldValue} = action.payload;
        const newState = {...action.payload.state};

        newState[form][fieldName].fieldName = fieldName;
        newState[form][fieldName].fieldValue = Number(fieldValue);
        return newState;
    }
    return state;
};

export default formsReducer;