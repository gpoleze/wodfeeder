import {weeksAction, workoutFormAction} from './workouts.actions';
import React from "react";
import {Redirect} from "react-router-dom";

const API = 'api/wod';

export const listWeekWorkouts = (week, year) => {
    let url = API + '/week';

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

    const weekFormValues = {
        week: {
            fieldName: 'week',
            fieldValue: '',
            options: []
        },
        year: {
            fieldName: 'year',
            fieldValue: '',
            options: []
        }
    };

    return dispatch => fetch(API + '/weeks')
        .then(response => response.text())
        .then(response => JSON.parse(response))
        .then(weeksReturns => {
            const {weeks, years, currentWeek, currentYear} = weeksReturns;

            weekFormValues.week.fieldValue = currentWeek;
            weekFormValues.week.options = weeks.map(key => ({name: key, value: key}));

            weekFormValues.year.options = years.map(key => ({name: key, value: key}));
            weekFormValues.year.fieldValue = currentYear;

            return weekFormValues;

        })
        .then(weekFormValues => {
            dispatch(workoutFormAction(weekFormValues));
            return weekFormValues;
        });

};

export const reloadWorkouts = () => {
    fetch(API + '/reload');
    return <Redirect to='/'/>;
};

export const addFormChange = () => {
};