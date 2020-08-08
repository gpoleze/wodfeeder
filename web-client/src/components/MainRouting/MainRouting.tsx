import React from "react";

import { BrowserRouter as Router, Redirect, Route, Switch } from "react-router-dom";

import Workouts from "views/Workouts";

const MainRouting: React.FC = () => (
    <Router>
        <Switch>
            <Route path="/workouts" component={Workouts} />
            <Route exact path="/">
                <Redirect to="/workouts" />
            </Route>
        </Switch>
    </Router>
);

export default MainRouting;
