import React from 'react';
import {AppBar, IconButton, Toolbar, Typography} from '@material-ui/core';
import MenuIcon from '@material-ui/icons/Menu';
import {useStyles} from './styles'

const Header = props =>{
    const classes = useStyles();
    return (
        <div className={classes.root}>
            <AppBar position="static">
                <Toolbar>
                    <IconButton edge="start" className={classes.menuButton} color="inherit" aria-label="Menu">
                        <MenuIcon />
                    </IconButton>
                    <Typography variant="h6" className={classes.title}>
                        Wod Feeder
                    </Typography>
                </Toolbar>
            </AppBar>
        </div>
    );
};

export default Header;