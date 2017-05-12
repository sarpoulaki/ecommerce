package com.sarpoulaki;

import com.sarpoulaki.model.User;
import com.sarpoulaki.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


@Controller
@SessionAttributes("user")
public class LoginController {

    private UserService userService;

    @Autowired(required = true)
    @Qualifier(value = "userService")
    public void setUserService(UserService us) {
        this.userService = us;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginUser(ModelAndView modelAndView) {
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logoutUser(ModelAndView modelAndView) {
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    public ModelAndView validateUser(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
        user = this.userService.validateUser(user);
        if (user!=null) {
            modelAndView.addObject("user", user);
            modelAndView.setViewName("redirect:/");
        } else {
            modelAndView.addObject("message", "Invalid User name or password!");
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }

/*
    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    public String validateUser(@ModelAttribute("user") User user, Model model, HttpSession session) {
        if (this.userService.validateUser(user)) {
            session.setAttribute("user", user);
            return "redirect:/";
        } else {
            model.addAttribute("message", "Invalid User name or password!");
            return "login";
        }
    }
*/

    @RequestMapping(value = "/newUser", method = RequestMethod.GET)
    public String newUser(@ModelAttribute("user") User user) {
        return "newuser";
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView addNewUser(@ModelAttribute("user") User user) {
        String message = this.userService.addUser(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("newuser");
        if ("".equals(message)) {
            modelAndView.addObject("message", "User was added successfuly");
//            return "redirect:/login";
        } else {
            modelAndView.addObject("message", message);
//            return "newuser";
        }
        return modelAndView;
    }
}


