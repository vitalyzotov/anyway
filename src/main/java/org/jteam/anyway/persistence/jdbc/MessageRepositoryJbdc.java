package org.jteam.anyway.persistence.jdbc;

import org.jteam.anyway.domain.model.MessageId;
import org.jteam.anyway.domain.model.MessageRepository;
import org.jteam.anyway.domain.model.Person;
import org.jteam.anyway.domain.model.PersonId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.Types;
import java.util.Optional;
import java.util.stream.Stream;

public class MessageRepositoryJbdc implements MessageRepository {
    private static final Logger log = LoggerFactory.getLogger(MessageRepositoryJbdc.class);
    public static final String SELECT_BY_ID = "SELECT * FROM message_ WHERE MESSAGE_UID=:id";
    public static final String INSERT_OR_UPDATE = """
                    INSERT INTO message_ (MESSAGEID, AUTHORID, MESSAGETYPE, CREATED, RECIPENTID, TEXT, DATA  )
                    VALUES (:messageId,:authorId,:messageType,:created,:recipientId,:text,:date)
            ON DUPLICATE KEY UPDATE
            MESSAGEID=:messageId
            AUTHORID=:authorId
            MESSAGETYPE=:messageType
            CREATED=:created
            RECIPENTID=:recipientId
            TEXT=:text
            DATA=:date
            """.replaceAll("[\\r\\n]+", "");
}
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public MessageRepositoryJbdc(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<String> find(MessageId MessageId) {
        try {
            return jdbcTemplate.queryForObject(
                    SELECT_BY_ID,
                    new MapSqlParameterSource()
                            .addValue("id", MessageId.getValue(), Types.VARCHAR),
