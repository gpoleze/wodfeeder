import React from 'react'
import {transitionAction, weeksAction, workoutFormAction, workoutFormEditAction} from './workouts.actions';
import {Redirect} from "react-router-dom";
import {initialState} from "./initial-state";


const API = 'api/wod';

export const listWeekWorkouts = (week, year) => {
    let url = API + '/week';

    if (!!week) {
        if (!!year)
            url = `${url}/${week}/year/${year}`;
        else
            url = `${url}/${week}`;
    }

    return dispatch => fetch(url)
        .then(response => response.text())
        .then(response => JSON.parse(response))
        .then(workouts => {
            dispatch(transitionAction({checked: false}));
            return workouts;
        })
        .then(workouts => new Promise((resolve, reject) => setTimeout(() => resolve(workouts), initialState.workouts.transition.timeout)))
        .then(workouts => {
            dispatch(weeksAction(workouts));
            dispatch(transitionAction({checked: true}));
            return workouts;
        });
};

export const getWorkoutFormAttributes = () => {
    return dispatch => fetch(API + '/weeks')
        .then(response => response.text())
        .then(response => JSON.parse(response))
        .then(weeksReturns => {
            const {weeks, years, currentWeek, currentYear} = weeksReturns;
            const weekFormValues = {...initialState.workouts.weekFormValues};

            weekFormValues.week.fieldValue = currentWeek;
            weekFormValues.week.options = weeks.map(key => ({name: key, value: key}));

            weekFormValues.year.fieldValue = currentYear;
            weekFormValues.year.options = years.map(key => ({name: key, value: key}));

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

export const addFormChange = (fieldName, fieldValue) => {
    const inputChanged = {fieldName, fieldValue};
    return dispatch => {
        dispatch(workoutFormEditAction(inputChanged));
        return inputChanged;
    };
};