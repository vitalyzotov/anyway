package org.jteam.anyway.persistence.jdbc;

import org.jteam.anyway.domain.model.Person;
import org.jteam.anyway.domain.model.PersonId;
import org.jteam.anyway.domain.model.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Locale;

@JdbcTest
@ActiveProfiles("test")
class PersonRepositoryJdbcTest {

    private PersonRepository personRepository;

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @BeforeEach
    void setUp() {
        personRepository = new PersonRepositoryJdbc(jdbcTemplate);
    }

    @Test
    void find() {
        personRepository.find(PersonId.nextId());
    }

    @Test
    void store() {
        personRepository.store(new Person(
                PersonId.nextId(),
                "password hash",
                "John",
                "Snow",
                LocalDate.of(1813, Month.MARCH, 15),
                "England",
                "York",
                "+71234567890",
                "University of London",
                "Westminster Hospital",
                List.of(Locale.ENGLISH.getLanguage()),
                null
        ));
    }
}
