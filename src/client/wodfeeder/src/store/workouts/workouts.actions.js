import {TRANSITION_STATE, WEEKS_WORKOUTS} from "./workouts.constants";

export const weeksAction = workouts => ({
    type: WEEKS_WORKOUTS,
    payload: workouts
});

export const transitionAction = (transition) => {
    return {
        type: TRANSITION_STATE,
        payload: transition
    }
};