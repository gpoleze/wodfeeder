import React from 'react';
import {AppBar, IconButton, Toolbar, Typography, makeStyles} from '@material-ui/core';
import MenuIcon from '@material-ui/icons/Menu';

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
                </Toolbar>
            </AppBar>
        </div>
    );
};

export default Header;