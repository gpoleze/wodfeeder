import React from 'react';
import ReactDOM from 'react-dom'
import App from './App';

import './index.css';
import {BrowserRouter, Route, Switch} from "react-router-dom";
import {Provider} from "react-redux";
import {store} from "./stores/store";
import ButtonAppBar from "./header/ButtonAppBar";

ReactDOM.render(
    <Provider store={store}>
        <ButtonAppBar/>
        <BrowserRouter>
            <Switch>
                <Route exact path='/' component={App}/>
                <Route component={() => <div>'Page not Found 404'</div>}/>
            </Switch>
        </BrowserRouter>
    </Provider>
    , document.getElementById('root')
);
