import {formEditAction} from "./forms.actions";

export const addFormChange = (form, fieldName, fieldValue) => {
    return (dispatch, getState) => {
        const inputChanged = {
            form,
            fieldName,
            fieldValue,
            state: getState().forms
        };
        dispatch(formEditAction(inputChanged));
        return inputChanged;
    };
};