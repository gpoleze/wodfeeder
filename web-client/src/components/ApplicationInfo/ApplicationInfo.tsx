import React from "react";

import useStyles from "./ApplicationInfo.styles";

const ApplicationInfo: React.FC = () => {
    const classes = useStyles();
    return (
        <div className={classes.appVersion} data-key="applicationInfo">
            <p id="nodeEnv">{process.env.NODE_ENV}</p>
            <p id="appVersion">{process.env.REACT_APP_WEB_CLIENT_VERSION}</p>
        </div>
    );
};

export default ApplicationInfo;
