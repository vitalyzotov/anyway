package org.jteam.anyway.domain.model;

import java.util.Optional;

public interface PersonRepository {

    Optional<Person> find(PersonId personId);

    void store(Person person);
}
