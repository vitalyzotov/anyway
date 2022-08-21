package org.jteam.anyway.domain.model;

import java.util.List;
import java.util.Optional;

public interface CommunityRepository {
    Optional<Community> find(CommunityId communityId);

    public List<Community> find(String title);


    default void store(Community community) {

    }

    int delete(CommunityId communityId);
}