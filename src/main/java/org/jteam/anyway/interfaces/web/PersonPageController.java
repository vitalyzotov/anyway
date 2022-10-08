package org.jteam.anyway.interfaces.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonPageController {

    private static final Logger log = LoggerFactory.getLogger(PersonPageController.class);

    @GetMapping("/listperson")
    public String personPage(Model model) {
        return "list-person";
    }
}