import React from 'react';
import ReactDOM from 'react-dom'
import {BrowserRouter, Route, Switch} from "react-router-dom";
import {Provider} from "react-redux";

import App from './containers/App';
import Header from "./components/header/header.index";
import {store} from "./store/store";

import './index.css';
import {reloadWorkouts} from "./store/workouts/workouts.thunk";


ReactDOM.render(
    <Provider store={store}>
        <Header/>
        <BrowserRouter>
            <Switch>
                <Route exact path='/' component={App}/>
                <Route path='/week' component={App}/>
                <Route path='/reload' component={reloadWorkouts}/>
                <Route component={() => <div>'Page not Found 404'</div>}/>
            </Switch>
        </BrowserRouter>
    </Provider>
    , document.getElementById('root')
);
