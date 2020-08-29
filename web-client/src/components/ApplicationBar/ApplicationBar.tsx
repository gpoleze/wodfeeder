import React from "react";

import AppBar from "@material-ui/core/AppBar";
import IconButton from "@material-ui/core/IconButton";
import Toolbar from "@material-ui/core/Toolbar";
import Typography from "@material-ui/core/Typography";
import DarkThemeIcon from "@material-ui/icons/Brightness4";
import LightThemeIcon from "@material-ui/icons/Brightness7";
import MenuIcon from "@material-ui/icons/Menu";
import clsx from "clsx";
import { Link } from "react-router-dom";

import LoginButton from "components/LoginButton/LoginButton";

import useStyles from "./ApplicationBar.styles";

export interface IApplicationBarProps {
    open?: boolean;
    darkTheme?: boolean;
    isLoggedIn?: boolean;
    handleDrawer: () => void;
    handleTheme: () => void;
}

const ApplicationBar: React.FC<IApplicationBarProps> = ({
    open = false,
    darkTheme = false,
    isLoggedIn = false,
    handleDrawer,
    handleTheme,
}) => {
    const classes = useStyles();

    return (
        <AppBar position="absolute" className={clsx(classes.appBar, open && classes.appBarShift)}>
            <Toolbar className={classes.toolbar}>
                {isLoggedIn ? (
                    <IconButton
                        edge="start"
                        color="inherit"
                        aria-label="open drawer"
                        onClick={handleDrawer}
                        className={clsx(classes.menuButton, open && classes.menuButtonHidden)}
                    >
                        <MenuIcon />
                    </IconButton>
                ) : (
                    ""
                )}
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
