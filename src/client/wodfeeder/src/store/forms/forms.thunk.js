import {formEditAction, isSubmitButtonDisabledAction} from "./forms.actions";

export const addFormChange = (form, inputVo, newValue) => {
    return (dispatch, getState) => {
        const inputChanged = {
            form,
            inputVo,
            newValue
        };
        dispatch(formEditAction(inputChanged));
        dispatch(isSubmitButtonDisabledAction(form));
        return inputChanged;
    };
};

export const isSubmitButtonDisabled = form => {
    return dispatch => dispatch(isSubmitButtonDisabledAction(form));
};