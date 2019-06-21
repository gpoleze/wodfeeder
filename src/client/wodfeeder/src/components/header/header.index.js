import React from 'react';
import {
    AppBar,
    Button,
    IconButton,
    makeStyles,
    Toolbar,
    Typography
} from '@material-ui/core';
import MenuIcon from '@material-ui/icons/Menu';
import {login} from "../../store/app-bar/sign-in/login.thunk";

const useStyles = makeStyles(theme => ({
    root: {
        flexGrow: 1,
        paddingBottom: theme.spacing(8)
    },
    menuButton: {
        marginRight: theme.spacing(2),
        display: 'none'
    },
    title: {
        flexGrow: 1,
    },
}));

const Header = props =>{
    const classes = useStyles();
    return (
        <div className={classes.root}>
            <AppBar position="fixed">
                <Toolbar>
                    <IconButton edge="start" className={classes.menuButton} color="inherit" aria-label="Menu">
                        <MenuIcon />
                    </IconButton>
                    <Typography variant="h6" className={classes.title} data-test="headerText">
                        Wod Feeder
                    </Typography>
                    <Button color="inherit" onClick={login}>Login</Button>
                </Toolbar>
            </AppBar>
        </div>
    );
};

export default Header;