import React from "react";

import Typography from "@material-ui/core/Typography";

export interface ITitleProps {
    children: React.ReactNode;
}

const Title: React.FC<ITitleProps> = ({ children }) => (
    <Typography component="h2" variant="h6" color="primary" gutterBottom>
        {children}
    </Typography>
);

export default Title;
