import React from "react";
import GoogleLogin, { GoogleLoginResponse, GoogleLoginResponseOffline, GoogleLogout } from "react-google-login";

const CLIENT_ID = "993603213209-9cur29do2unitei5612mje0mi1rqp0la.apps.googleusercontent.com";

export interface IGoogleLoginButtonProps {
    isLoggedIn: boolean;
    redirect_uri: string;
    className?: string;
}

const GoogleLoginButton: React.FC<IGoogleLoginButtonProps> = ({ isLoggedIn, redirect_uri, className = "" }) => {
    const login = (response: GoogleLoginResponse | GoogleLoginResponseOffline) => {
        console.log(response);
    };

    const loginFailureHandler = (error: any) => {
        console.log(`Error to login: ${error}`);
    };

    const logout = () => {
        console.log("Logged Out");
    };

    const logoutFailureHandler = () => {
        console.log("Error to Log Out");
    };

    return (
        <div className={className}>
            {isLoggedIn ? (
                <GoogleLogout
                    clientId={CLIENT_ID}
                    buttonText="Logout"
                    onLogoutSuccess={logout}
                    onFailure={logoutFailureHandler}
                />
            ) : (
                <GoogleLogin
                    clientId={CLIENT_ID}
                    buttonText="Login in with Google"
                    onSuccess={login}
                    onFailure={loginFailureHandler}
                    cookiePolicy={"single_host_origin"}
                    responseType="id_token"
                />
            )}
        </div>
    );
};

export default GoogleLoginButton;
