package org.jteam.anyway.interfaces.web;

import org.jteam.anyway.domain.model.Person;
import org.jteam.anyway.domain.model.PersonId;
import org.jteam.anyway.domain.model.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    // person?name=ася
    @GetMapping("/person")
    public List<PersonReference> search(@RequestParam String name) {
        final List<PersonReference> result = new ArrayList<>();
        final List<Person> people = personRepository.find(name);
        for(Person p: people) {
            PersonReference ref = new PersonReference();
            ref.setId(p.getId().getValue());
            ref.setFistName(p.getFirstName());
            ref.setLastName(p.getLastName());

            result.add(ref);
        }

        return result;
    }

    @GetMapping("/person/{id}")
    public PersonData getById(@PathVariable String id) {
        final Optional<Person> personOptional = personRepository.find(new PersonId(id));
        if (personOptional.isPresent()) {
            Person person = personOptional.get();

            PersonData result = new PersonData();

            result.setId(person.getId().getValue());
            result.setFirstName(person.getFirstName());
            result.setLastName(person.getLastName());

            return result;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/person/{id}")
    public PersonData update(@PathVariable String id, @RequestBody PersonData data) {
        Optional<Person> optional = personRepository.find(new PersonId(id));
        if(optional.isPresent()) {

            Person person = optional.get();
            person.setFirstName(data.getFirstName());
            person.setLastName(data.getLastName());

            personRepository.store(person);

            PersonData result = new PersonData();

            result.setId(person.getId().getValue());
            result.setFirstName(person.getFirstName());
            result.setLastName(person.getLastName());

            return result;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/person/{id}")
    public void delete(@PathVariable String id) {
        int numberOfDeleted = personRepository.delete(new PersonId(id));
        if(numberOfDeleted < 1) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
