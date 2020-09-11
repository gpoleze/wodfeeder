import React, { useEffect, useMemo } from "react";

import { useMediaQuery } from "@material-ui/core";
import CssBaseline from "@material-ui/core/CssBaseline";
import { ThemeProvider } from "@material-ui/core/styles";
import { BrowserRouter as Router } from "react-router-dom";

import ApplicationBar from "components/ApplicationBar";
import ApplicationDrawer from "components/ApplicationDrawer";
import ApplicationInfo from "components/ApplicationInfo";
import MainRouting from "components/MainRouting";

import useStyles, { createTheme } from "./App.styles";

export interface IAppStateProps {
    darkTheme: boolean;
    slideOpen: boolean;
    isLoggedIn: boolean;
}

export interface IAppDispatchProps {
    toggleTheme: () => void;
    toggleSlide: () => void;
}

export interface IAppProps extends IAppStateProps, IAppDispatchProps {}

const App: React.FC<IAppProps> = ({ darkTheme, slideOpen, isLoggedIn, toggleTheme, toggleSlide }) => {
    const classes = useStyles();
    const theme = useMemo(() => createTheme(darkTheme), [darkTheme]);

    const darkModePreference = useMediaQuery("(prefers-color-scheme: dark)");
    useEffect(() => {
        if (darkTheme !== darkModePreference) toggleTheme();
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, [darkModePreference]);

    return (
        <ThemeProvider theme={theme}>
            <div className={classes.root}>
                <CssBaseline />
                <ApplicationInfo />
                <Router>
                    <ApplicationBar
                        open={slideOpen}
                        handleDrawer={toggleSlide}
                        darkTheme={darkTheme}
                        handleTheme={toggleTheme}
                        isLoggedIn={isLoggedIn}
                    />
                    {isLoggedIn ? <ApplicationDrawer open={slideOpen} handleDrawer={toggleSlide} /> : ""}
                    <main className={classes.content}>
                        <div className={classes.appBarSpacer}>
                            <MainRouting />
                        </div>
                    </main>
                </Router>
            </div>
        </ThemeProvider>
    );
};

export default App;
