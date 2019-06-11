import React, {Component} from 'react';
import PropTypes from "prop-types";

import './App.css';

import Workouts from "./workouts/workouts.container";

class App extends Component {
    static contentTypes = {
        store: PropTypes.object.isRequired
    };

    render() {
        return (
            <div id="root">
                <div className="main">
                    <Workouts/>
                </div>
            </div>
        );
    }
}

export default App;
