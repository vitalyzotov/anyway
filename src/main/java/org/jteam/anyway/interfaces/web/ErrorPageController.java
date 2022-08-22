package org.jteam.anyway.interfaces.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorPageController {

    @GetMapping("/error")
    public String loginPage(Model model) {
        return "error";
    }

}
