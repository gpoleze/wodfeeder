const API = '/api/user';

function validateResponse(response) {
    if (response.ok)
        return response.text();

    throw new Error(response);

}

export const login = (username, password) => {
    const data = {
        username:'gabriel.poleze@gmail.com',
        password:'123456789'
    };

    fetch(API + '/signin', {
        method: 'POST',
        body: JSON.stringify(data),
        headers: {
            'Content-Type': 'application/json',
            // 'Content-Type': 'application/x-www-form-urlencoded',
        },
    })
        .then(response => validateResponse(response))
        .then(response => JSON.parse(response))
        .then(user => console.log(user));


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