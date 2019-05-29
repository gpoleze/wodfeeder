import {weeksAction} from '../reducers/actions/actionCreator';

export const listWeekWorkouts = (week, year = new Date().getFullYear()) => {
    let url;
    if (!week)
        url = 'wod/week';
    else if (!year)
        url = `wod/week/${week}`;
    else
        url = `/wod/week/${week}/year/${year}`;

    return dispatch => fetch(url)
        .then(response => response.text())
        .then(response => JSON.parse(response))
        .then(workouts => {
            dispatch(weeksAction(workouts));
            return workouts;
        });
};
