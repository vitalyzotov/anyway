import React, {useEffect, useState} from "react";
import useToken from "../../useToken";
import authFetch from "../../authFetch";

export function Users() {
    const [users, setUsers] = useState([]);
    const {token} = useToken();

    useEffect(() => {
        authFetch(token, "/api/person")
            .then(response => response.json())
            .then(_data => setUsers(_data))
            .catch(function () {
                console.log("Не получилось загрузить людей!!!");
            });
    }, []);

    return (
        <div>
            <h1>Пользователи</h1>
            <div>
                {users.map(user => <div key={user.id}><span>{user.firstName}</span>&nbsp;<span>{user.lastName}</span></div>)}
            </div>
        </div>
    );
}
