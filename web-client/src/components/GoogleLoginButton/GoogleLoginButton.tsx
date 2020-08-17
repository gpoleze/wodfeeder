import React, { useState } from "react";
import {
    GoogleLogin,
    GoogleLoginResponse,
    GoogleLoginResponseOffline,
    GoogleLogout,
    UseGoogleLogoutResponse
} from "react-google-login";
import axios from "axios";

const CLIENT_ID = "993603213209-9cur29do2unitei5612mje0mi1rqp0la.apps.googleusercontent.com";


export interface IGoogleLoginButtonProps {
    isLogged: boolean;
    accessToken: string;
}

const GoogleLoginButton: React.FC = () => {
    const [isLogged, setIsLogged] = useState(false);
    const [accessToken, setAccessToken] = useState('');

    const login = (response: GoogleLoginResponse | GoogleLoginResponseOffline): void => {
            console.log(response);

        setIsLogged(true);
        const {accessToken} = response as GoogleLoginResponse
        const loginResponse = response as GoogleLoginResponse
        setAccessToken(accessToken)
        axios("http://localhost:8080/api/auth/google", {
            method: "POST",
            data: loginResponse.tokenId,
            headers: {
                // 'Access-Control-Allow-Origin': '*',
                "Content-Type": "application/json"
            },
        });
        // if (response.code) {
        //
        //     setIsLogged(true);
        //     setAccessToken(response.accessToken);
        // }
    }

    const logout = (): void => {
        setIsLogged(false);
        setAccessToken('');
    }

    const handleLoginFailure = (response: GoogleLoginResponse): void => {
        alert('Failed to log in')
    }

    const handleLogoutFailure = (response: UseGoogleLogoutResponse): void => {
        alert('Failed to log out')
    }

    const responseGoogle = (response:any) => {
        console.log(response);
    }

    return (
        <div>
            {isLogged
                ? <GoogleLogout
                    clientId={CLIENT_ID}
                    buttonText='Logout'
                    onLogoutSuccess={logout}
                    onFailure={() => console.log('error to log out')}
                />
                : <GoogleLogin
                    clientId={CLIENT_ID}
                    buttonText='Login'
                    onSuccess={login}
                    onFailure={responseGoogle}
                    cookiePolicy={'single_host_origin'}
                    responseType='id_token'
                />
            }
            {/*{accessToken ? <h5>Your Access Token: <br/><br/> {accessToken}</h5> : null}*/}

        </div>
    );
}
export default GoogleLoginButton;