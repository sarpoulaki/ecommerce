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

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    private UserService userService;

    @Autowired(required = true)
    @Qualifier(value = "userService")
    public void setUserService(UserService us) {
        this.userService = us;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String listUsers(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    public String validateUser(@ModelAttribute("user") User user, Model model, HttpSession session) {
        if (this.userService.validateUser(user)) {
            session.setAttribute("username", user.getName());
            return "redirect:/";
        } else {
            model.addAttribute("message", "Invalid User name or password!");
            return "login";
        }
    }

    @RequestMapping(value = "/newUser", method = RequestMethod.GET)
    public String newUser(@ModelAttribute("user") User user) {
        return "newuser";
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String addNewUser(@ModelAttribute("user") User user, Model model) {
        String message = this.userService.addUser(user);

        if ("".equals(message)) {
            model.addAttribute("message", "User was added successfuly");
//            return "redirect:/login";
        } else {
            model.addAttribute("message", message);
//            return "newuser";
        }
        return "newuser";
    }
}


