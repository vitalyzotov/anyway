import './Messages.css'
import React, {useEffect, useState} from "react";
import useToken from "../../useToken";
import authFetch from "../../authFetch";

export function Messages() {
    const [messages, setMessages] = useState([]);
    const {token} = useToken();

    useEffect(() => {
        authFetch(token, "/api/message")
            .then(response => response.json())
            .then(_data => setMessages(_data))
            .catch(function () {
                console.log("Не получилось загрузить сообщения!!!");
            });
    }, []);

    return (
        <div>
            <h1>Messages Page!</h1>
            <div>
                {messages.map(message => <div className="message" data-message-id={message.messageid}>
                    <div className="message-author">
                        {message.authorId}
                    </div>
                    <div className="form-floating mb-4 message-recipient">
                        написал
                        {message.recipientId}
                    </div>
                    <div className="message-created">
                        {message.createdFormatted}
                    </div>
                    <div className="message-text">
                        {message.text}
                    </div>
                </div>)}
            </div>
        </div>
    );
}
