import {weeksAction, workoutFormAction} from './workouts.actions';

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

export const getWorkoutFormAttributes = () => {
    //TODO - make the URL request to fetch the next group of values
    const weekFormValues = {
        week: {
            fieldName: 'week',
            fieldValue: 23,
            options: [...Array(52).keys()].map(key => ({name: key + 1, value: key + 1}))
        },
        year: {
            fieldName: 'year',
            fieldValue: 2019,
            options: [
                {name: 2018, value: 2018},
                {name: 2019, value: 2019},
            ]
        }
    };

    return dispatch => {
        dispatch(workoutFormAction(weekFormValues));
        return weekFormValues;
    };
};
