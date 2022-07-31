package org.jteam.anyway.persistence.jdbc;

import org.jteam.anyway.domain.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.Optional;

public class MessageRepositoryJbdc implements MessageRepository {
    private static final Logger log = LoggerFactory.getLogger(MessageRepositoryJbdc.class);

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public MessageRepositoryJbdc(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Message> find(MessageId messageId) {
        try {
            String sql = "SELECT * FROM message_ as m left join message_data_ as md on m.MESSAGE_UID=md.MESSAGE_UID WHERE MESSAGE_UID=:id";
            SqlParameterSource parameters = new MapSqlParameterSource()
                    .addValue("id", messageId.getValue(), Types.VARCHAR);
            return jdbcTemplate.queryForObject(sql, parameters, new RowMapper<Optional<Message>>() {
                @Override
                public Optional<Message> mapRow(ResultSet rs, int rowNum) throws SQLException {
                    return Optional.of(new Message(
                            new MessageId(rs.getString("MESSAGE_UID")),
                            new PersonId(rs.getString("AUTHOR_UID")),
                            MessageType.from(rs.getString("TYPE")),
                            rs.getTimestamp("CREATED").toInstant(),
                            new PersonId(rs.getString("RECIPIENT_UID")),
                            rs.getString("TEXT"),
                            rs.getBytes("DATA")
                    ));
                }
            });
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public void store(Message message) {
        jdbcTemplate.update(
                """
                       INSERT INTO message_ (MESSAGE_UID, AUTHOR_UID,TYPE, CREATED, RECIPIENT_UID, TEXT) VALUES 
                       (:messageId,:authorId,:messageType,:created,:recipientId,:text) 
                       ON DUPLICATE KEY UPDATE 
                            AUTHOR_UID=:authorId, 
                            TYPE=:messageType,
                            CREATED=:created,
                            RECIPIENT_UID=:recipientId, 
                            TEXT=:text
                """,
                new MapSqlParameterSource()
                        .addValue("messageId", message.getMessageId().getValue())
                        .addValue("authorId", message.getAuthorId().getValue())
                        .addValue("messageType", message.getMessageType().getSymbol())
                        .addValue("created", Timestamp.from(message.getCreated()))
                        .addValue("recipientId", message.getRecipientId().getValue())
                        .addValue("text", message.getText())

        );

        if(message.getData() == null) {
            // delete data from database
            jdbcTemplate.update("DELETE FROM message_data_ WHERE MESSAGE_UID=:messageId",
                    new MapSqlParameterSource().addValue("messageId", message.getMessageId().getValue()));
        } else {
            // update data in database
            jdbcTemplate.update("INSERT INTO message_data_ (MESSAGE_UID, DATA) VALUES (:messageId, :data) ON DUPLICATE KEY UPDATE DATA=:data",
                    new MapSqlParameterSource()
                            .addValue("messageId", message.getMessageId().getValue())
                            .addValue("data", message.getData())
            );
        }
    }

}