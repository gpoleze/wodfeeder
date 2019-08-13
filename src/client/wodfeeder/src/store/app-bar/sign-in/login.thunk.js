const API = '/api/user';

function validateResponse(response) {
    if (response.ok)
        return response.text();

    throw new Error(response);

}

export const login = (username, password) => {
    const data = {username,password};

    return dispatch => fetch(API + '/signin', {
        method: 'POST',
        body: JSON.stringify(data),
        headers: {
            'Content-Type': 'application/json',
            // 'Content-Type': 'application/x-www-form-urlencoded',
        },
    })
        .then(response => validateResponse(response))
        .then(user => console.log(user));
};
