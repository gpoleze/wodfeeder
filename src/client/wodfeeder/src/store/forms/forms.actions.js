import {FORM_EDIT, FORM_VIEW, SUBMIT_BUTTON} from "./forms.constants";

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

export const isSubmitButtonDisabledAction = form => {
    return ({
        type: SUBMIT_BUTTON,
        payload: form,
    })
};