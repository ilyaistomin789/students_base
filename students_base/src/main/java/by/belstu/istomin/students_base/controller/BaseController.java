package by.belstu.istomin.students_base.controller;

import by.belstu.istomin.students_base.forms.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BaseController {
    @RequestMapping(value = {"/", "main"}, method = RequestMethod.GET)
    public ModelAndView main(Model model){
        ModelAndView modelAndView = new ModelAndView("main");
        return modelAndView;
    }
    @RequestMapping(value = {"/authorize"}, method = RequestMethod.GET)
    public ModelAndView getAuthorizePage(Model model){
        ModelAndView modelAndView = new ModelAndView("authorize");
        LoginForm loginForm = new LoginForm();
        model.addAttribute("logForm", loginForm);
        return modelAndView;
    }
    @RequestMapping(value = {"/authorize"}, method = RequestMethod.POST)
    public ModelAndView authorization(Model model, @ModelAttribute("logForm") LoginForm loginForm){
        ModelAndView modelAndView = new ModelAndView("account");
        String userName = loginForm.getUserName();
        String password = loginForm.getPassword();
        if (userName != null && userName.length() > 0 && password != null && password.length() > 0){

        }
        return modelAndView;
    }
}
