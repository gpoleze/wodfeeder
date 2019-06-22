import React from 'react';
import {Link} from "react-router-dom";
import {AppBar, Button, IconButton, Toolbar, Typography} from '@material-ui/core';
import MenuIcon from '@material-ui/icons/Menu';
import headerStyles from "./header.style";

const navigateToLogin = React.forwardRef((props, ref) => <Link innerRef={ref} {...props} />);

const Header = props => {
    const classes = headerStyles();
    return (
        <div className={classes.root}>
            <AppBar position="fixed" onClick={(e) => console.log(e)}>
                <Toolbar>
                    <IconButton edge="start" className={classes.menuButton} color="inherit" aria-label="Menu">
                        <MenuIcon/>
                    </IconButton>
                    <Typography variant="h6" className={classes.title} data-test="headerText">
                        <Link to={'/'} className={classes.link}>
                            Wod Feeder
                        </Link>
                    </Typography>
                    <Button
                        variant={'outlined'}
                        color={'inherit'}
                        size={'small'}
                        to={'/login'}
                        component={navigateToLogin}>
                        Login
                    </Button>
                </Toolbar>
            </AppBar>
        </div>
    );
};

export default Header;