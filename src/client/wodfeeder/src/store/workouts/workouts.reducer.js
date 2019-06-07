import {List} from 'immutable'

export const weekWorkouts = (state = [], action) => {
    if (action.type === 'weeksWorkouts')
        return new List(action.workouts);

    return state;
};
