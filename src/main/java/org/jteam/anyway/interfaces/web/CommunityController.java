package org.jteam.anyway.interfaces.web;

import org.jteam.anyway.domain.model.Community;
import org.jteam.anyway.domain.model.CommunityRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CommunityController {

    private final CommunityRepository communityRepository;

    public CommunityController(CommunityRepository communityRepository) {
        this.communityRepository = communityRepository;
    }

    @GetMapping("/community")
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

}
