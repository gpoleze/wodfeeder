import makeStyles from "@material-ui/core/styles/makeStyles";

export default makeStyles((theme) => ({
    paper: {
        width: "90%",
        maxWidth: 600,
        margin: "0 auto",
        marginTop: theme.spacing(4),
        padding: theme.spacing(2),
    },
    formControl: {
        width: "90%",
        margin: "auto",
        marginTop: theme.spacing(1),
        marginBottom: theme.spacing(1),
    },
}));
