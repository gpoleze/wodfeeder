import {makeStyles} from "@material-ui/core";

const headerStyles = makeStyles(theme => ({
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

export default headerStyles;
