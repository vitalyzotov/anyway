package org.jteam.anyway.interfaces.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MessagePageController {

    private static final Logger log = LoggerFactory.getLogger(MessagePageController.class);

    @GetMapping("/message")
    public String messagePage(Model model) {
        return "message";
    }
}
