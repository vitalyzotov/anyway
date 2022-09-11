package org.jteam.anyway.interfaces.web;

import org.jteam.anyway.domain.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MessageController {

    private final MessageRepository messageRepository;

    public MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @GetMapping("message")
    public List<MessageReference> search(@RequestParam(required = false) String text) {
        final List<MessageReference> result = new ArrayList<>();

        final List<Message> message = messageRepository.find(text);

        for(Message p: message) {
            MessageReference ref = new MessageReference();
            ref.setText(p.getText());
            ref.setAuthorId(p.getAuthorId().getValue());
            ref.setMessageid(p.getMessageId().getValue());
            ref.setCreated(p.getCreated());
            ref.setRecipientId(p.getRecipientId().getValue());
            result.add(ref);
        }

        return result;
    }
    @GetMapping("message/{id}")
    public MessageData getById(@PathVariable String id) {
        final Optional<Message> messageOptional = messageRepository.find(new MessageId(id));
        if (messageOptional.isPresent()) {
            MessageData result = new MessageData();

            // у меня есть переменная message с типом Message
            Message message = messageOptional.get();

            // мне нужен идентификатор этого сообщения. получаю его
            MessageId messageId = message.getMessageId();

            // но он мне нужен не как тип MessageId, а как строка. Преобразую его в строку
            String messageIdAsString = messageId.getValue();

            // теперь у меня в переменной messageIdAsString лежит строка с идентификатором сообщения
            String messageIdAsString2 = message.getMessageId().getValue();

            result.setMessageId(message.getMessageId().getValue());
            result.setAuthorId(message.getAuthorId());
            result.setText(message.getText());

            return result;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("message/{id}")
    public MessageData update(@PathVariable String id, @RequestBody MessageData data) {
        Optional<Message> optional = messageRepository.find(new MessageId(id));
        if(optional.isPresent()) {

            Message message = optional.get();
           message.setText(data.getText());
            message.setMessageId(data.getMessageId());

            messageRepository.store(message);

            MessageData result = new MessageData();

            result.setMessageId(message.getMessageId().getValue());
            result.setText(message.getText());
            result.setAuthorId(message.getAuthorId());

            return result;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
