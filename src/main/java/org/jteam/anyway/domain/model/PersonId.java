package org.jteam.anyway.domain.model;

import java.util.Objects;
import java.util.Random;
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

    public static PersonId nextNumericId() {
        Random random = new Random();
        // [0; 9 999 999]
        return new PersonId(String.valueOf(random.nextInt(0, 10000000)));
    }

    @Override
    public String toString() {
        return value;
    }
}
