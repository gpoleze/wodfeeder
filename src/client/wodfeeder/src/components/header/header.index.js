import React from 'react';
import {Link} from "react-router-dom";
import {
    AppBar,
    Button,
    IconButton,
    makeStyles,
    Toolbar,
    Typography
} from '@material-ui/core';
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
    link: {
        all: 'unset',
        cursor: 'pointer',
    }
}));

const navigateToLogin = React.forwardRef((props, ref) => <Link innerRef={ref} {...props} />);
const navigateToHome = () => <Link to={'/'}/>;

const Header = props => {
    const classes = useStyles();
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