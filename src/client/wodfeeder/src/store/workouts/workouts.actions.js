import {TRANSITION_STATE, WEEKS_WORKOUTS, WORKOUTS_FORM_EDIT, WORKOUTS_FORM_VIEW} from "./workouts.constants";

export const weeksAction = workouts => ({
    type: WEEKS_WORKOUTS,
    payload: workouts
});

export const workoutFormAction = weekFormValues => {
    return {
        type: WORKOUTS_FORM_VIEW,
        payload: weekFormValues
    }
};

export const workoutFormEditAction = weekFormValues => {
    return {
        type: WORKOUTS_FORM_EDIT,
        payload: weekFormValues
    }
};

export const transitionAction = (transition) => {
    return {
        type: TRANSITION_STATE,
        payload: transition
    }
};