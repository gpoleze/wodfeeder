import React from "react";

import Divider from "@material-ui/core/Divider";
import Drawer from "@material-ui/core/Drawer";
import IconButton from "@material-ui/core/IconButton";
import List from "@material-ui/core/List";
import ListItem from "@material-ui/core/ListItem";
import ListItemIcon from "@material-ui/core/ListItemIcon";
import ListItemText from "@material-ui/core/ListItemText";
import makeStyles from "@material-ui/core/styles/makeStyles";
import AssignmentIcon from "@material-ui/icons/Assignment";
import ChevronLeftIcon from "@material-ui/icons/ChevronLeft";
import DashboardIcon from "@material-ui/icons/Dashboard";
import clsx from "clsx";
import { Link } from "react-router-dom";

import { drawerWidth } from "components/sharedVariables";

export interface IApplicationDrawerProps {
    open?: boolean;
    handleDrawer: () => void;
}

const useStyles = makeStyles((theme) => ({
    root: {
        display: "flex",
    },
    drawerPaper: {
        position: "relative",
        whiteSpace: "nowrap",
        width: drawerWidth,
        transition: theme.transitions.create("width", {
            easing: theme.transitions.easing.sharp,
            duration: theme.transitions.duration.enteringScreen,
        }),
    },
    drawerPaperClose: {
        overflowX: "hidden",
        transition: theme.transitions.create("width", {
            easing: theme.transitions.easing.sharp,
            duration: theme.transitions.duration.leavingScreen,
        }),
        width: theme.spacing(7),
        [theme.breakpoints.up("sm")]: {
            width: theme.spacing(9),
        },
    },
    toolbarIcon: {
        display: "flex",
        alignItems: "center",
        justifyContent: "flex-end",
        padding: "0 8px",
        ...theme.mixins.toolbar,
    },
}));

const mainListItems = (
    <div>
        <Link to="/workouts" style={{ textDecoration: "none", color: "inherit" }}>
            <ListItem button>
                <ListItemIcon>
                    <DashboardIcon />
                </ListItemIcon>
                <ListItemText primary="Workouts" />
            </ListItem>
        </Link>
        <Link to="/workouts/new" style={{ textDecoration: "none", color: "inherit" }}>
            <ListItem button>
                <ListItemIcon>
                    <AssignmentIcon />
                </ListItemIcon>
                <ListItemText primary="New Workout" />
            </ListItem>
        </Link>
    </div>
);
const secondaryListItems = "";

const ApplicationDrawer: React.FC<IApplicationDrawerProps> = ({ open = false, handleDrawer }) => {
    const classes = useStyles();
    return (
        <Drawer
            variant="permanent"
            classes={{
                paper: clsx(classes.drawerPaper, !open && classes.drawerPaperClose),
            }}
            open={open}
        >
            <div className={classes.toolbarIcon}>
                <IconButton onClick={handleDrawer}>
                    <ChevronLeftIcon />
                </IconButton>
            </div>
            <Divider />
            <List>{mainListItems}</List>
            <Divider />
            <List>{secondaryListItems}</List>
        </Drawer>
    );
};

export default ApplicationDrawer;
