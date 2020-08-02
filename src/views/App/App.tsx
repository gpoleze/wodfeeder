import React, { useState } from "react";

import Box from "@material-ui/core/Box";
import CssBaseline from "@material-ui/core/CssBaseline";

import ApplicationBar from "components/ApplicationBar";
import ApplicationDrawer from "components/ApplicationDrawer";
import Copyright from "components/Copyright";
import Workouts from "views/Workouts";

import useStyles from "./App.styles";

const App: React.FC = () => {
    const [open, setOpen] = useState(false);
    const classes = useStyles();

    return (
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
    );
};

export default App;
