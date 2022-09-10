document.addEventListener("DOMContentLoaded", function () {
    console.log("I am loaded");

    fetch("/api/message")
        .then(function (response) {
            return response.json();
        })
        .then(function (data) {
            let messages = document.getElementById("anyway-messages");
            let messageTemplate = (message) => html`
                <div style="border:1px solid red" data-message-id="${message.messageid}">
                    <div style="border:1px solid green; float:left">
                        ${message.authorid}
                    </div>
                    <div style="border:1px solid black; float:right">
                        18:36 18.07.2022 выведи меня из модели
                    </div>
                    <div style="clear:both">
                        ${message.text}
                    </div>
                </div>`;
            messages.innerHTML = '';
            for (const m of data) {
                messages.innerHTML += render(m, messageTemplate);
            }
        })
        .catch(function () {
            console.log("Не получилось загрузить сообщения!!!");
        });
});

