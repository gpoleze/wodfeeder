import {FORM_EDIT, FORM_VIEW} from "./forms.constants";

export const formEditAction = formValues => {
    return {
        type: FORM_EDIT,
        payload: formValues
    }
};

export const formViewAction = formValues => {
    return {
        type: FORM_VIEW,
        payload: formValues
    }
};