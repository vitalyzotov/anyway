package org.jteam.anyway.domain.model;


import java.util.Optional;

public interface MessageRepository {
    Optional<Message> find(MessageId messageId);

    void store(Message message);
}

