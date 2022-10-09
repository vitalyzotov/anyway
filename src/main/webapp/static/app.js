document.addEventListener("DOMContentLoaded", function () {
    console.log("I am loaded");

    let body = document.body;
    let pageId = body.dataset.page;
    console.log(pageId);

    if(pageId === 'messages') {
        showMessages();
    } else if (pageId==='users') {
        showUsers();
    }
});

function showUsers() {
    console.log('fetch and show users');

    fetch("/api/person")
        .then(function (response) {
            return response.json();
        })
        .then(function (data) {
            let person = document.getElementById("anyway-listperson");
            let listpersonTemplate = (person) => html`
                <div style="border:1px solid red" data-person-id="${person.Id}">
                    <div style="border:1px solid green; float:left">
                        ${person.firstName}
                    </div>
                    <div class="form-floating mb-4; float:left">
                        ${person.lastName}
                    </div>
                </div>`;
            person.innerHTML = '';
            for (const m of data) {
                m.createdFormatted = formatDate(m.created);
                person.innerHTML += render(m, listpersonTemplate);
            }
        })
        .catch(function () {
            console.log("Не получилось загрузить людей!!!");
        });
}

function showMessages() {
     fetch("/api/person")
            .then(function (response) {
                return response.json();
            })
            .then(function (data) {
                let person = document.getElementById("anyway-listperson");
                let listpersonTemplate = (person) => html`
                    <div style="border:1px solid red" data-person-id="${person.Id}">
                        <div style="border:1px solid green; float:left">
                            ${person.firstName}
                        </div>
                        <div class="form-floating mb-4; float:left">
                            ${person.lastName}
                        </div>
                    </div>`;
                person.innerHTML = '';
                for (const m of data) {
                    m.createdFormatted = formatDate(m.created);
                    person.innerHTML += render(m, listpersonTemplate);
                }
            })
            .catch(function () {
                console.log("Не получилось загрузить людей!!!");
            });
    }


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
