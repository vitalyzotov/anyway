package org.jteam.anyway.domain.model;

import java.util.Objects;
import java.util.UUID;

public class PersonId {
    private final String value;

    public String getValue() {
        return value;
    }

    public PersonId(String value) {
        Objects.requireNonNull(value);
        this.value = value;
    }

    public static PersonId nextId() {
        return new PersonId(UUID.randomUUID().toString());
    }
}
