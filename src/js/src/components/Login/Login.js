import './Login.css';
import React, {useState} from "react";

async function loginUser(credentials) {
    return fetch('/authenticate', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(credentials)
    })
        .then(data => data.json())
}

export function Login({setToken}) {
    const [username, setUserName] = useState();
    const [password, setPassword] = useState();

    const handleSubmit = async e => {
        e.preventDefault();
        const token = await loginUser({
            username,
            password
        });
        setToken(token);
    };

    return (
        <div className="container">
            <div className="row justify-content-center">
                <div className="col-4">
                    <h1 className="text-center">Anyway</h1>
                    <form onSubmit={handleSubmit}>
                        <div className="form-group mb-3">
                            <label htmlFor="loginFormUsername">Пользователь</label>
                            <input className="form-control" id="loginFormUsername" type="text"
                                   onChange={e => setUserName(e.target.value)}/>
                        </div>
                        <div className="form-group mb-3">
                            <label htmlFor="loginFormPassword">Пароль</label>
                            <input className="form-control" id="loginFormPassword" type="password"
                                   onChange={e => setPassword(e.target.value)}/>
                        </div>
                        <div className="text-center">
                            <button type="submit" className="btn btn-primary">Войти</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    );
}
