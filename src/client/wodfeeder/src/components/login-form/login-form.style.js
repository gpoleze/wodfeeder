import {makeStyles} from "@material-ui/core";

const loginFormStyle = makeStyles(theme => ({
    paper: {
        zIndex: 1,
        maxWidth: "320px",
        maxHeight: "80%",
        margin: "20px auto",
        padding: '20px 10px'
    },
    form: {
        textAlign: 'center'
    },
    inputGroup: {},
    button: {
        marginTop: '20px'
    }
}));

export default loginFormStyle;

