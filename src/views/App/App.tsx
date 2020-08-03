import React, { useMemo, useState } from "react";

import Box from "@material-ui/core/Box";
import CssBaseline from "@material-ui/core/CssBaseline";

import ApplicationBar from "components/ApplicationBar";
import ApplicationDrawer from "components/ApplicationDrawer";
import Copyright from "components/Copyright";
import Workouts from "views/Workouts";
import { useMediaQuery } from "@material-ui/core";
import { ThemeProvider } from "@material-ui/core/styles";

import useStyles, { createTheme } from "./App.styles";

const App: React.FC = () => {
    const darkMode = useMediaQuery("(prefers-color-scheme: dark)");
    const theme = useMemo(() => createTheme(darkMode), [darkMode]);
    const [open, setOpen] = useState(false);
    const classes = useStyles();

    return (
        <ThemeProvider theme={theme}>
            <div className={classes.root}>
                <CssBaseline />
                <ApplicationBar open={open} handleDrawer={(): void => setOpen(!open)} />
                <ApplicationDrawer open={open} handleDrawer={(): void => setOpen(!open)} />
                <main className={classes.content}>
                    <div className={classes.appBarSpacer}>
                        <Workouts />
                    </div>
                </main>
                <footer className={classes.footer}>
                    <Box pt={4}>
                        <Copyright />
                    </Box>
                </footer>
            </div>
        </ThemeProvider>
    );
};

export default App;
