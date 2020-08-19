import React from "react";

import { Redirect, Route, Switch } from "react-router-dom";

import Login from "views/Login";
import Workouts from "views/Workouts";

const MainRouting: React.FC = () => (
    <Switch>
        <Route path="/workouts" component={Workouts} />
        <Route path="/login" component={Login} />
        <Route exact path="/">
            <Redirect to="/workouts" />
        </Route>
    </Switch>
);

export default MainRouting;
