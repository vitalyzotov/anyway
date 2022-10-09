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
export function Login({ setToken }) {
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
        <div className="login-wrapper">
            <h1>Anyway</h1>
            <form onSubmit={handleSubmit}>
                <label>
                    <p>Пользователь</p>
                    <input type="text" onChange={e => setUserName(e.target.value)} />
                </label>
                <label>
                    <p>Пароль</p>
                    <input type="password" onChange={e => setPassword(e.target.value)} />
                </label>
                <div>
                    <button type="submit">Войти</button>
                </div>
            </form>
        </div>
    );
}
