package org.jteam.anyway.interfaces.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginFormController {

    private static final Logger log = LoggerFactory.getLogger(LoginFormController.class);

    @GetMapping("/login")
    public String loginPage(HttpSession session, Model model, @RequestParam(name = "error", required = false, defaultValue = "false") boolean isError) {
        if (isError) {
            final Exception exception = (Exception) session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
            if (exception != null) {
                model.addAttribute("error", exception.getMessage());
            }
        }
        return "login";
    }

}
