package org.jteam.anyway.persistence.jdbc;

import liquibase.pro.packaged.P;
import org.jteam.anyway.domain.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.Assert;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@JdbcTest
@ActiveProfiles("test")
class MessageRepositoryJdbcTest {

    private MessageRepository messageRepository;

    private PersonRepository personRepository;

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @BeforeEach
    void setUp() {
        messageRepository = new MessageRepositoryJbdc(jdbcTemplate);
        personRepository = new PersonRepositoryJdbc(jdbcTemplate);
    }

    @Test
    void find() {
        Optional<Message> m = messageRepository.find(MessageId.nextId());
        Assert.notNull(m, "This optional must not be null");
    }

    @Test
    void store() {
        PersonId person1 = PersonId.nextId();
        personRepository.store(new Person(
                person1, "password hash",
                "John", "Snow", LocalDate.now(), "Saratov", "Saratov", "", "", "", List.of(), null
        ));
        messageRepository.store(new Message(
                MessageId.nextId(),
                person1,
                MessageType.TEXT,
                Instant.now(),
                person1,
                "Message text",
                null
        ));
    }

}
