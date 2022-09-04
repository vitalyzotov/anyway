package org.jteam.anyway.interfaces.web;

import org.jteam.anyway.domain.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CommunityController {

    private final CommunityRepository communityRepository;

    public CommunityController(CommunityRepository communityRepository) {
        this.communityRepository = communityRepository;
    }

    @GetMapping("community")
    public List<CommunityReference> search(@RequestParam String title) {
        final List<CommunityReference> result = new ArrayList<>();
        final List<Community> communityList = communityRepository.find(title);
        for (Community p : communityList) {
            CommunityReference ref = new CommunityReference();
            ref.setId(p.getId().asString());
            ref.setTitle(p.getTitle());
            ref.setDescription(p.getDescription());

            result.add(ref);
        }

        return result;
    }

    @GetMapping("community/{id}")
    public CommunityData getById(@PathVariable String id) {
        final Optional<Community> communityOptional = communityRepository.find(new CommunityId(id));
        if (communityOptional.isPresent()) {
            Community community = communityOptional.get();

            CommunityData result = new CommunityData();

            result.setId(community.getId().asString());
            result.setTitle(community.getTitle());
            result.setDescription(community.getDescription());

            return result;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("community/{id}")
    public CommunityData update(@PathVariable String id, @RequestBody CommunityData data) {
        Optional<Community> optional = communityRepository.find(new CommunityId(id));
        if (optional.isPresent()) {

            Community community = optional.get();
            community.setTitle(data.getTitle());
            community.setDescription(data.getDescription());

            communityRepository.store(community);

            CommunityData result = new CommunityData();

            result.setId(community.getId().asString());
            result.setTitle(community.getTitle());
            result.setDescription(community.getDescription());

            return result;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("community/{id}")
    public void delete(@PathVariable String id) {
        int numberOfDeleted = communityRepository.delete(new CommunityId(id));
        if (numberOfDeleted < 1) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
