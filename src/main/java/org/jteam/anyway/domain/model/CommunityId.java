package org.jteam.anyway.domain.model;

import java.util.Objects;

public class CommunityId {
    private final String value;

    public String getValue() {
        return value;
    }

    public CommunityId(String value) {
        Objects.requireNonNull(value);
        this.value = value;
    }
}
