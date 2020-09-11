import makeStyles from "@material-ui/core/styles/makeStyles";

export default makeStyles((theme) => ({
    container: {
        paddingTop: theme.spacing(4),
        paddingBottom: theme.spacing(4),
    },
    footer: {
        position: "fixed",
        left: 0,
        bottom: 0,
        width: "100%",
        textAlign: "center",
    },
}));
