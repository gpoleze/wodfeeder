import React from "react";

import { BrowserRouter as Router, Redirect, Route, Switch } from "react-router-dom";

import Workouts from "views/Workouts";
import Login from "views/Login";

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
