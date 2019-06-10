import {makeStyles} from "@material-ui/core";

const selectInputStyles = makeStyles(theme => ({
    formControl: {
        margin: theme.spacing(1),
        minWidth: 70,
        maxWidth: '90%'
    },
    selectEmpty: {
        marginTop: theme.spacing(2),
    },
}));

export default selectInputStyles;
