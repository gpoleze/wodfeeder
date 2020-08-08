import React, { Key, ReactNode } from "react";

import Paper from "@material-ui/core/Paper";
import clsx from "clsx";

import useStyle from "./DisplayBox.styles";

export interface IDisplayBoxProps {
    fixedHeight?: boolean;
    children?: ReactNode;
    key?: Key;
}

const DisplayBox: React.FC<IDisplayBoxProps> = ({ key = "", children = undefined, fixedHeight = false }) => {
    const classes = useStyle();

    return (
        <Paper key={key} className={clsx(classes.paper, fixedHeight && classes.fixedHeight)}>
            {children}
        </Paper>
    );
};

export default DisplayBox;
