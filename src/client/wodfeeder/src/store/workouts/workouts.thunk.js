import React from 'react'
import {transitionAction, weeksAction} from './workouts.actions';
import {Redirect} from "react-router-dom";
import {workoutsInitialState} from "./workouts.initial-state";
import {formViewAction} from "../forms/forms.actions";


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
        .then(workouts => new Promise((resolve, reject) => setTimeout(() => resolve(workouts), workoutsInitialState.workouts.transition.timeout)))
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
            const workoutsForm = {...workoutsInitialState.forms.workoutsForm};

            workoutsForm.week.fieldValue = currentWeek;
            workoutsForm.week.options = weeks.map(key => ({name: key, value: key}));

            workoutsForm.year.fieldValue = currentYear;
            workoutsForm.year.options = years.map(key => ({name: key, value: key}));

            return workoutsForm;

        })
        .then(workoutsForm => {
            dispatch(formViewAction({workoutsForm: workoutsForm}));
            return workoutsForm;
        });

};

export const reloadWorkouts = () => {
    fetch(API + '/reload');
    return <Redirect to='/'/>;
};
