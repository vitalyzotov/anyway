
package org.jteam.anyway.persistence.jdbc;

import org.jteam.anyway.domain.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CommunityRepositoryJdbc implements CommunityRepository {
    private static final Logger log = LoggerFactory.getLogger(CommunityRepositoryJdbc.class);

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public CommunityRepositoryJdbc(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public static final String INSERT_OR_UPDATE = """
                INSERT INTO community_ (COMMUNITY_UID, ADMIN_UID, DESCRIPTION, TITLE, SUBJECT)
                VALUES (:communityId, :adminId, :description, :title, :subject)
                ON DUPLICATE KEY UPDATE
                ADMIN_UID=:adminId,
                DESCRIPTION=:description,
                TITLE=:title,
                SUBJECT=:subject
            """;

    @Override
    public Optional<Community> find(CommunityId communityId) {
        try {
            return jdbcTemplate.queryForObject(
                    "SELECT * FROM community_ as c left join community_photo_ as cp on c.COMMUNITY_UID=cp.COMMUNITY_UID WHERE c.COMMUNITY_UID=:id",
                    new MapSqlParameterSource().addValue("id", communityId.asString()),
                    new RowMapper<Optional<Community>>() {
                        @Override
                        public Optional<Community> mapRow(ResultSet rs, int rowNum) throws SQLException {
                            return Optional.of(new Community(
                                    new CommunityId(rs.getString("COMMUNITY_UID")),
                                    rs.getString("DESCRIPTION"),
                                    rs.getString("TITLE"),
                                    rs.getString("SUBJECT"),
                                    new PersonId(rs.getString("ADMIN_UID")),
                                    new ArrayList<>(),
                                    new ArrayList<>(),
                                    rs.getBytes("PHOTO_")


                            ));
                        }
                    }
            );
        } catch (Exception e) {
            log.error("error", e);
            return Optional.empty();
        }
    }

    @Override
    public List<Community> find(String title) {
        String sql = "SELECT * FROM community_ WHERE title like :title";

        MapSqlParameterSource parameters;
        parameters = new MapSqlParameterSource();
        parameters.addValue("title", "%" + title + "%");

        RowMapper<Community> rowMapper = new RowMapper<Community>() {
            @Override
            public Community mapRow(ResultSet rs, int rowNum) throws SQLException {
                String communityIdValue = rs.getString("COMMUNITY_UID");

                CommunityId id = new CommunityId(communityIdValue);
                String description = rs.getString("DESCRIPTION");
                String communityTitle = rs.getString("TITLE");
                String subject = rs.getString("SUBJECT");

                String personIdValue = rs.getString("ADMIN_UID");

                PersonId administrator = new PersonId(personIdValue);
                List<PersonId> members = new ArrayList<>();
                List<EventCommunity> events = new ArrayList<>();
                byte[] photo = null;

                Community result = new Community(id, description, communityTitle, subject, administrator, members, events, photo);

                return result;
            }
        };

        return jdbcTemplate.query(sql, parameters, rowMapper);
    }

    @Override
    public void store(Community community) {
        jdbcTemplate.update(INSERT_OR_UPDATE,
                new MapSqlParameterSource()
                        .addValue("communityid", community.getId().asString())
                        .addValue("adminId", community.getAdministrator().getValue())
                        .addValue("description", community.getDescription())
                        .addValue("title", community.getTitle())
                        .addValue("subject", community.getSubject())
        );
        if (community.getPhoto() == null) {
            // delete data from database
            jdbcTemplate.update("DELETE FROM community_photo_ WHERE COMMUNITY_UID=:communityID",
                    new MapSqlParameterSource().addValue("communityId", community.getId().asString()));
        } else {
            jdbcTemplate.update("INSERT INTO community_photo_ (PHOTO_, COMMUNITY_UID) VALUES (:photo, :communityId) ON DUPLICATE KEY UPDATE PHOTO_=:photo",
                    new MapSqlParameterSource()
                            .addValue("photo", community.getPhoto())
                            .addValue("communityId", community.getId().asString())
            );
        }
    }

    public int delete(CommunityId communityId) {
        return jdbcTemplate.update(
                "DELETE FROM person_ WHERE PERSON_UID=:id",
                new MapSqlParameterSource().addValue("id", communityId.asString())
        );
    }
}
