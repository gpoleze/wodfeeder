import React from 'react'
import AppBar from '@material-ui/core/AppBar';
import Typography from "@material-ui/core/Typography";
import {makeStyles} from "@material-ui/core";

class Header extends React.Component {
    render() {
        const classes = useStyles();
        return (
            <AppBar position='static'>
                <Typography variant="h6" className={classes.title}>
                    Wod Feeder
                </Typography>
                {/*<p>All your workouts in your hands</p>*/}
            </AppBar>
        );
    }
}

export default Header;