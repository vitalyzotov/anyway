package org.jteam.anyway.domain.model;


import java.util.Optional;

public interface MessageRepository {
    Optional<String> find(MessageId MessageId);

    void store(String String);
}

