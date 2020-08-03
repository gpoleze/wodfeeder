import makeStyles from "@material-ui/core/styles/makeStyles";
import createMuiTheme from "@material-ui/core/styles/createMuiTheme";
import blueGrey from "@material-ui/core/colors/blueGrey";

export const createTheme = (darkMode: boolean) =>
    createMuiTheme({
        palette: {
            type: darkMode ? "dark" : "light",
            primary: blueGrey,
        },
    });

export default makeStyles((theme) => ({
    root: { display: "flex" },
    content: {
        marginTop: theme.spacing(8),
        flexGrow: 1,
        height: "100vh",
        overflow: "auto",
    },
    appBarSpacer: theme.mixins.toolbar,
    footer: {
        position: "fixed",
        left: 0,
        bottom: 0,
        width: "100%",
        textAlign: "center",
    },
}));
