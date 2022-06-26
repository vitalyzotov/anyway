package org.jteam.anyway.persistence.jdbc;

import org.jteam.anyway.domain.model.Community;
import org.jteam.anyway.domain.model.CommunityId;
import org.jteam.anyway.domain.model.CommunityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CommunityRepositoryjdbc implements CommunityRepository {

    private static final Logger log = LoggerFactory.getLogger(CommunityRepositoryjdbc.class);
    public static final String SELECT_BY_ID = """
            SELECT * FROM community_ WHERE COMMUNITY_UID=:id""";

    public static final String INSERT_OR_UPDATE = """
        INSERT INTO community_ (COMMUNITY_UID, ADMINISTRATOR, MEMBERS, DESCRIPTION, TITLE, SUBJECT EVENTS )
        VALUES (:id)


    @Override
    public Optional<Community> find(CommunityId communityId) {
        return Optional.empty();
    }

    @Override
    public void store(Community community) {

    }
}
