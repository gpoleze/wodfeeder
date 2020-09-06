import React from "react";

import { Button } from "@material-ui/core";
import Avatar from "@material-ui/core/Avatar";
import { Link } from "react-router-dom";

import useStyle from "./LoginButton.styles";

interface ILoginButtonProps {
    isLoggedIn: boolean;
    userImageUrl?: string;
    userName?: string;
}

const LoginButton: React.FC<ILoginButtonProps> = ({ isLoggedIn, userImageUrl, userName }) => {
    const classes = useStyle();
    if (!isLoggedIn)
        return (
            <Button variant="outlined" className={classes.button}>
                <Link to="/login" className={classes.link}>
                    Login
                </Link>
            </Button>
        );
    // if (userImageUrl)
    return <Avatar alt={userName} src={userImageUrl} />;
    // return (
    //     <Avatar>
    //         <AccountCircle />
    //     </Avatar>
    // );
};

export default LoginButton;
