const authFetch = async (token, input, init) => {
    console.log(token);
    init = init || {};

    init.headers = {
        ...init.headers,
        Authorization: `Bearer ${token}`,
    };

    return fetch(input, init);
};

export default authFetch;
