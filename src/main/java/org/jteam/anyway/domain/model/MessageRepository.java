package org.jteam.anyway.domain.model;


import java.util.List;
import java.util.Optional;

public interface MessageRepository {
    List<Message> find(String text);

    Optional<Message> find(MessageId messageId);

    void store(Message message);

}


