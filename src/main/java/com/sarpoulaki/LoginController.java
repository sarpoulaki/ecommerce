package com.sarpoulaki;

import com.sarpoulaki.model.User;
import com.sarpoulaki.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    private UserService userService;

    @Autowired(required = true)
    @Qualifier(value="userService")
    public void setUserService(UserService us) {
        this.userService = us;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String listUsers(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }
    @RequestMapping("/validate")
    public String validateUser(@ModelAttribute("user") User user, Model model) {
        if (this.userService.validateUser(user)) {
            return "home";
        } else {
            model.addAttribute("message","Invalid User name or password!");
            return "redirect:/login";
        }
    }
}

