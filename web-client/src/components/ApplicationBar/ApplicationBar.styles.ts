import makeStyles from "@material-ui/core/styles/makeStyles";

import { drawerWidth } from "components/sharedVariables";

export default makeStyles((theme) => ({
    root: { display: "flex" },
    appBar: {
        zIndex: theme.zIndex.drawer + 1,
        transition: theme.transitions.create(["width", "margin"], {
            easing: theme.transitions.easing.sharp,
            duration: theme.transitions.duration.leavingScreen,
        }),
    },
    appBarShift: {
        marginLeft: drawerWidth,
        width: `calc(100% - ${drawerWidth}px)`,
        transition: theme.transitions.create(["width", "margin"], {
            easing: theme.transitions.easing.sharp,
            duration: theme.transitions.duration.enteringScreen,
        }),
    },
    menuButton: {
        marginRight: 36,
    },
    menuButtonHidden: {
        display: "none",
    },
    title: {
        flexGrow: 1,
    },
    toolbar: {
        paddingRight: 24,
    },
    link: {
        textDecoration: "none",
        color: "inherit",
    },
}));
