import React, {Component} from 'react';
import PropTypes from "prop-types";

import './App.css';

import MainArea from "./main-area/MainArea";

class App extends Component {
    static contentTypes = {
        store: PropTypes.object.isRequired
    };

    render() {
        return (
            <div id="root">
                <div className="main">
                    <MainArea/>
                </div>
            </div>
        );
    }
}

export default App;
