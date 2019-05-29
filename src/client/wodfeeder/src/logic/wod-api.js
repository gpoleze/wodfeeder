import {weeksAction} from '../reducers/actions/actionCreator';

export const listWeekWorkouts = (week, year) => {
    let url = 'api/wod/week';

    if (year)
        if (week)
            url = `${url}/${week}/year/${year}`;
        else
            url = `${url}/${week}`;

    return dispatch => fetch(url)
        .then(response => response.text())
        .then(response => JSON.parse(response))
        .then(workouts => {
            dispatch(weeksAction(workouts));
            return workouts;
        });
};
