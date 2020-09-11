import React from "react";

import { Redirect, Route, Switch } from "react-router-dom";

import Login from "views/Login";
import Workout from "views/Workout";
import Workouts from "views/Workouts";

const MainRouting: React.FC = () => (
    <Switch>
        <Route exact path="/workouts" component={Workouts} />
        <Route path="/workouts/new" component={Workout} />
        <Route path="/login" component={Login} />
        <Route exact path="/">
            <Redirect to="/workouts" />
        </Route>
    </Switch>
);

export default MainRouting;
