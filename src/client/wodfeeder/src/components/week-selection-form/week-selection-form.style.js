import {makeStyles} from "@material-ui/core";

const weekSelectionFormStyles = makeStyles(theme => ({
    form: {
        display: 'inline-block',
        flexWrap: 'wrap',
        justifyContent: 'center',
    },
    formContainer:{
        textAlign:'center'
    },
    selectInput:{},
    button:{
        marginTop: theme.spacing(2)
    }
}));

export default weekSelectionFormStyles;
