package org.jteam.anyway.interfaces.web;

import org.jteam.anyway.domain.model.Person;
import org.jteam.anyway.domain.model.PersonId;
import org.jteam.anyway.domain.model.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;

@RestController
public class SignupRestController {

    private static final Logger log = LoggerFactory.getLogger(SignupRestController.class);

    private final PersonRepository personRepository;

    public SignupRestController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping("/signup")
    public void signup(@RequestBody PersonData data) {
        log.info("signup " + data.getFirstName());

        Person person = new Person(
                PersonId.nextNumericId(),
                data.getFirstName(),
                data.getLastName(),
                LocalDate.now(),
                "Россия",
                "Саратов",
                "123456",
                "нет",
                "безработный", new ArrayList<>(), null
        );

        personRepository.store(person);
    }
}
