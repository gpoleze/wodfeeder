import React from "react";

import AppBar from "@material-ui/core/AppBar";
import IconButton from "@material-ui/core/IconButton";
import Toolbar from "@material-ui/core/Toolbar";
import Typography from "@material-ui/core/Typography";
import AccountCircle from "@material-ui/icons/AccountCircle";
import MenuIcon from "@material-ui/icons/Menu";
import clsx from "clsx";

import useStyles from "./ApplicationBar.styles";

export interface IApplicationBarProps {
    open?: boolean;
    handleDrawer: () => void;
}

const ApplicationBar: React.FC<IApplicationBarProps> = ({ open = false, handleDrawer }) => {
    const classes = useStyles();

    return (
        <AppBar position="absolute" className={clsx(classes.appBar, open && classes.appBarShift)}>
            <Toolbar className={classes.toolbar}>
                <IconButton
                    edge="start"
                    color="inherit"
                    aria-label="open drawer"
                    onClick={handleDrawer}
                    className={clsx(classes.menuButton, open && classes.menuButtonHidden)}
                >
                    <MenuIcon />
                </IconButton>
                <Typography component="h1" variant="h6" color="inherit" noWrap className={classes.title}>
                    WodFeeder
                </Typography>
                <IconButton color="inherit" onClick={(): void => console.log("Will execute the login in the future")}>
                    <AccountCircle />
                </IconButton>
            </Toolbar>
        </AppBar>
    );
};

export default ApplicationBar;
