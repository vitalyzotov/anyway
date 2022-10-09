package org.jteam.anyway.persistence.jdbc;

import org.jteam.anyway.domain.model.Person;
import org.jteam.anyway.domain.model.PersonId;
import org.jteam.anyway.domain.model.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Types;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Repository
public class PersonRepositoryJdbc implements PersonRepository {

    private static final Logger log = LoggerFactory.getLogger(PersonRepositoryJdbc.class);

    public static final String SELECT_BY_ID = """
            SELECT * FROM person_ WHERE PERSON_UID=:id""";

    public static final String INSERT_OR_UPDATE = """
            INSERT INTO person_ (PERSON_UID, PASSWORD, FIRST_NAME, LAST_NAME, BIRTH_DATE, CITY, COUNTRY, PLACE_OF_WORK, PHONE_MOBILE, EDUCATION, LANGUAGES) 
            VALUES (:id, :password, :firstName, :lastName, :birthDate, :city, :country, :placeOfWork, :mobilePhone, :education, :languages)
            ON DUPLICATE KEY UPDATE
                PASSWORD=:password,
                FIRST_NAME=:firstName,
                LAST_NAME=:lastName,
                BIRTH_DATE=:birthDate,
                CITY=:city,
                COUNTRY=:country,
                PLACE_OF_WORK=:placeOfWork,
                PHONE_MOBILE=:mobilePhone,
                EDUCATION=:education,
                LANGUAGES=:languages
            """.replaceAll("[\\r\\n]+", "");

    private final NamedParameterJdbcTemplate jdbcTemplate;

    private RowMapper<Person> personRowMapper = (rs, rowNum) -> {
        Date birthDate = rs.getDate("BIRTH_DATE");
        return new Person(
                new PersonId(rs.getString("PERSON_UID")),
                rs.getString("PASSWORD"),
                rs.getString("FIRST_NAME"),
                rs.getString("LAST_NAME"),
                birthDate == null ? null : birthDate.toLocalDate(),
                rs.getString("COUNTRY"),
                rs.getString("CITY"),
                rs.getString("PHONE_MOBILE"),
                rs.getString("EDUCATION"),
                rs.getString("PLACE_OF_WORK"),
                Optional.ofNullable(rs.getString("LANGUAGES"))
                        .stream()
                        .<String>mapMulti(
                                (languages, accept) -> Stream.of(languages.split(","))
                                        .map(String::trim)
                                        .forEachOrdered(accept)
                        )
                        .toList(),
                null

        );
    };

    public PersonRepositoryJdbc(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Person> find(String name) {
        if (name == null) {
            return jdbcTemplate.query("SELECT * FROM person_", personRowMapper);

        }
        return jdbcTemplate.query("SELECT * FROM person_ WHERE FIRST_NAME like :name OR LAST_NAME like :name",
                new MapSqlParameterSource().addValue("name", "%" + name + "%"), personRowMapper);

    }


    @Override
    public Optional<Person> find(PersonId personId) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(
                    SELECT_BY_ID,
                    new MapSqlParameterSource()
                            .addValue("id", personId.getValue(), Types.VARCHAR),
                    personRowMapper
            ));
        } catch (EmptyResultDataAccessException e) {
            log.debug("Person {} not found", personId, e);
            return Optional.empty();
        }
    }

    @Override
    public void store(Person person) {
        jdbcTemplate.update(
                INSERT_OR_UPDATE,
                new MapSqlParameterSource()
                        .addValue("id", person.getId().getValue(), Types.VARCHAR)
                        .addValue("password", person.getPassword(), Types.VARCHAR)
                        .addValue("firstName", person.getFirstName(), Types.VARCHAR)
                        .addValue("lastName", person.getLastName(), Types.VARCHAR)
                        .addValue("birthDate", person.getBirthday(), Types.DATE)
                        .addValue("city", person.getHometown(), Types.VARCHAR)
                        .addValue("country", person.getCountry(), Types.VARCHAR)
                        .addValue("placeOfWork", person.getPlaceOfWork(), Types.VARCHAR)
                        .addValue("mobilePhone", person.getMobilePhone(), Types.VARCHAR)
                        .addValue("education", person.getEducation(), Types.VARCHAR)
                        .addValue("languages", String.join(",", person.getLanguages()), Types.VARCHAR)
        );
        //TODO: добавить сохранение фотографии
    }

    @Override
    public int delete(PersonId personId) {
        return jdbcTemplate.update(
                "DELETE FROM person_ WHERE PERSON_UID=:id",
                new MapSqlParameterSource().addValue("id", personId.getValue())
        );
    }
}
