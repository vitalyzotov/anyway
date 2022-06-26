package org.jteam.anyway.domain.model;

import java.util.Optional;

public interface CommunityRepository {
    Optional<Community> find(CommunityId communityId);

    void store(Community community);


}
