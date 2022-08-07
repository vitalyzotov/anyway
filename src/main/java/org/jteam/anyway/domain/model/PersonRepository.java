package org.jteam.anyway.domain.model;

import java.util.List;
import java.util.Optional;

public interface PersonRepository {

    List<Person> find(String name);

    Optional<Person> find(PersonId personId);

    void store(Person person);

    int delete(PersonId personId);
}
