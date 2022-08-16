package org.jteam.anyway.interfaces.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SignupController {

    private static final Logger log = LoggerFactory.getLogger(SignupController.class);

    @GetMapping("/signup")
    public String signupPage(Model model) {
        return "signup";
    }

//    @PostMapping("/signup")
//    public String onCommit(Model model, HttpServletRequest request) {
//
//        log.info("Form submitted " + request.getParameter("firstName"));
//        return "after-signup";
//    }

}
