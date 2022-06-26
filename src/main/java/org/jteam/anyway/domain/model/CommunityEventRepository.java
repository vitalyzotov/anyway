package org.jteam.anyway.domain.model;

import java.util.List;
import java.util.Optional;

public interface CommunityEventRepository {
    Optional<EventCommunity> find (List<String> hmevents);

    void store(EventCommunity eventCommunity);
}
