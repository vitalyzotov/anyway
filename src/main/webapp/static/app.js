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
                        ${message.authorId}
                    </div>
                    <div class="form-floating mb-4; float:left">
                        написал
                        ${message.recipientId}
                    </div>
                    <div style="border:1px solid black; float:right">
                        ${message.createdFormatted}
                    </div>
                    <div style="clear:both">
                        ${message.text}
                    </div>
                </div>`;
            messages.innerHTML = '';
            for (const m of data) {
                m.createdFormatted = formatDate(m.created);
                messages.innerHTML += render(m, messageTemplate);
            }
        })
        .catch(function () {
            console.log("Не получилось загрузить сообщения!!!");
        });
});

