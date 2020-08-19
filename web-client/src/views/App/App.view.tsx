import React, { useEffect, useMemo } from "react";

import { useMediaQuery } from "@material-ui/core";
import Box from "@material-ui/core/Box";
import CssBaseline from "@material-ui/core/CssBaseline";
import { ThemeProvider } from "@material-ui/core/styles";

import ApplicationBar from "components/ApplicationBar";
import ApplicationDrawer from "components/ApplicationDrawer";
import Copyright from "components/Copyright";
import MainRouting from "components/MainRouting";
import Workouts from "views/Workouts";

import useStyles, { createTheme } from "./App.styles";
import { BrowserRouter as Router } from "react-router-dom";

export interface IAppProps {
    darkTheme?: boolean;
    slideOpen?: boolean;
    isLoggedIn?: boolean;
    toggleTheme?: () => void;
    toggleSlide?: () => void;
    toggleLogin?: () => void;
}

const App: React.FC<IAppProps> = ({
    darkTheme = false,
    slideOpen = false,
    isLoggedIn = false,
    toggleTheme = (): void => {},
    toggleSlide = (): void => {},
    toggleLogin = (): void => {},
}) => {
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
                <Router>
                    <ApplicationBar
                        open={slideOpen}
                        handleDrawer={toggleSlide}
                        darkTheme={darkTheme}
                        handleTheme={toggleTheme}
                        isLoggedIn={isLoggedIn}
                        handleLogin={toggleLogin}
                    />
                    {/* <ApplicationDrawer open={slideOpen} handleDrawer={toggleSlide} /> TODO - Uncoment this when you want to add more items to the menu */}
                    <main className={classes.content}>
                        <div className={classes.appBarSpacer}>
                            <MainRouting />
                        </div>
                    </main>
                    <footer className={classes.footer}>
                        <Box pt={4}>
                            <Copyright />
                        </Box>
                    </footer>
                </Router>
            </div>
        </ThemeProvider>
    );
};

export default App;
