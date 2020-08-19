import React from "react";

import AppBar from "@material-ui/core/AppBar";
import IconButton from "@material-ui/core/IconButton";
import Toolbar from "@material-ui/core/Toolbar";
import Typography from "@material-ui/core/Typography";
import DarkThemeIcon from "@material-ui/icons/Brightness4";
import LightThemeIcon from "@material-ui/icons/Brightness7";
import clsx from "clsx";

import useStyles from "./ApplicationBar.styles";
import LoginButton from "components/LoginButton/LoginButton";
import { Link } from "react-router-dom";

export interface IApplicationBarProps {
    open?: boolean;
    darkTheme?: boolean;
    isLoggedIn?: boolean;
    handleDrawer: () => void;
    handleTheme: () => void;
    handleLogin: () => void;
}

const ApplicationBar: React.FC<IApplicationBarProps> = ({
    open = false,
    darkTheme = false,
    isLoggedIn = false,
    handleDrawer,
    handleTheme,
    handleLogin,
}) => {
    const classes = useStyles();

    return (
        <AppBar position="absolute" className={clsx(classes.appBar, open && classes.appBarShift)}>
            <Toolbar className={classes.toolbar}>
                {/* <IconButton
                    edge="start"
                    color="inherit"
                    aria-label="open drawer"
                    onClick={handleDrawer}
                    className={clsx(classes.menuButton, open && classes.menuButtonHidden)}
                >
                    <MenuIcon />
                </IconButton> TODO - Uncoment when you want to add more items to the menu */}
                <Typography component="h1" variant="h6" color="inherit" noWrap className={classes.title}>
                    <Link to="/" className={classes.link}>
                        WodFeeder
                    </Link>
                </Typography>
                <IconButton color="inherit" onClick={handleTheme}>
                    {darkTheme ? <LightThemeIcon /> : <DarkThemeIcon />}
                </IconButton>
                <LoginButton isLoggedIn={isLoggedIn} />
            </Toolbar>
        </AppBar>
    );
};

export default ApplicationBar;
