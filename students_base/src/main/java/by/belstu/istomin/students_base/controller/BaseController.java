package by.belstu.istomin.students_base.controller;

import by.belstu.istomin.students_base.components.Component;
import by.belstu.istomin.students_base.forms.LoginForm;
import by.belstu.istomin.students_base.forms.RatingForm;
import by.belstu.istomin.students_base.forms.RegistrationForm;
import by.belstu.istomin.students_base.models.Student;
import by.belstu.istomin.students_base.models.User;
import by.belstu.istomin.students_base.models.Subject;
import by.belstu.istomin.students_base.models.Department;
import by.belstu.istomin.students_base.repository.SubjectRepository;
import by.belstu.istomin.students_base.service.StudentService;
import by.belstu.istomin.students_base.service.SubjectService;
import by.belstu.istomin.students_base.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.util.List;


@Controller
public class BaseController {
    private String message;
    //TODO check this place
    @Autowired
    private UserService userService;
    private StudentService studentService;
    private SubjectService subjectService;

    @RequestMapping(value = {"/", "main"}, method = RequestMethod.GET)
    public ModelAndView main(Model model) {
        return new ModelAndView("main");
    }

    @RequestMapping(value = {"/authorize"}, method = RequestMethod.GET)
    public ModelAndView getAuthorizePage(Model model) {
        ModelAndView modelAndView = new ModelAndView("authorize");
        LoginForm loginForm = new LoginForm();
        model.addAttribute("logForm", loginForm);
        return modelAndView;
    }

    @RequestMapping(value = {"/authorize"}, method = RequestMethod.POST)
    public ModelAndView authorization(Model model, @ModelAttribute("logForm") LoginForm loginForm) {
        ModelAndView modelAndView = new ModelAndView();
        String userName = loginForm.getUserName();
        String password = loginForm.getPassword();
        if (userName != null && userName.length() > 0 && password != null && password.length() > 0) {
            User user = userService.getUserByLoginAndPassword(userName, password);
            if (user != null) {
                model.addAttribute("currentUser", user);
                if (user.getRole().equals(Component.STUDENT_ROLE)) {
                    modelAndView.setViewName("studentAccount");
                } else if (user.getRole().equals(Component.ADMIN_ROLE)) {
                    modelAndView.setViewName("adminAccount");
                } else if (user.getRole().equals(Component.TEACHER_ROLE)) {
                    modelAndView.setViewName("teacherAccount");
                }
            } else {
                modelAndView.setViewName("authorize");
                message = "this user is not exist";
                model.addAttribute("message", message);
            }
            return modelAndView;
        } else {
            modelAndView.setViewName("authorize");
            message = "fields are not filled in";
            model.addAttribute("message", message);
            return modelAndView;
        }
    }

    @RequestMapping(value = {"/registration"}, method = RequestMethod.GET)
    public ModelAndView getRegistrationPage(Model model) {
        ModelAndView modelAndView = new ModelAndView("registration");
        RegistrationForm registrationForm = new RegistrationForm();
        model.addAttribute("regForm", registrationForm);
        return modelAndView;
    }

    @RequestMapping(value = {"/registration"}, method = RequestMethod.POST)
    public ModelAndView registration(Model model, @ModelAttribute("regForm") RegistrationForm registrationForm) throws ParseException {
        ModelAndView modelAndView = new ModelAndView("registration_success");
        String login = registrationForm.getLogin();
        String password = registrationForm.getPassword();
        String confirmPassword = registrationForm.getConfirmPassword();
        if (login != null && login.length() > 0 && password != null && password.length() > 0 &&
                confirmPassword != null && confirmPassword.length() > 0 && password.equals(confirmPassword)) {
            User user = new User();
            user.setLogin(login);
            user.setPassword(password);
            if (!userService.saveStudent(user)) {
                message = "This user is exists";
                modelAndView.setViewName("registration");
                model.addAttribute("message", message);
                return modelAndView;
            } else {
                message = "Registration was successful";
                model.addAttribute("message", message);
                return modelAndView;
            }
        } else {
            message = "Please, fill in all fields";
            modelAndView.setViewName("registration");
            model.addAttribute("message", message);
            return modelAndView;
        }
    }

    @RequestMapping(value = {"/teacherRegistration"}, method = RequestMethod.GET)
    public ModelAndView getTeacherRegistrationPage(Model model) {
        ModelAndView modelAndView = new ModelAndView("teacherRegistration");
        RegistrationForm registrationForm = new RegistrationForm();
        model.addAttribute("regForm", registrationForm);
        return modelAndView;
    }

    @RequestMapping(value = {"/teacherRegistration"}, method = RequestMethod.POST)
    public ModelAndView registrationTeacher(Model model, @ModelAttribute("regForm") RegistrationForm registrationForm) {
        ModelAndView modelAndView = new ModelAndView("registration_success");
        String login = registrationForm.getLogin();
        String password = registrationForm.getPassword();
        String confirmPassword = registrationForm.getConfirmPassword();
        if (login != null && login.length() > 0 && password != null && password.length() > 0 &&
                confirmPassword != null && confirmPassword.length() > 0 && password.equals(confirmPassword)) {
            User user = new User();
            user.setLogin(login);
            user.setPassword(password);
            if (!userService.saveTeacher(user)) {
                message = "This user is exists";
                modelAndView.setViewName("exception");
                model.addAttribute("message", message);
                return modelAndView;
            } else {
                message = "Registration was successful";
                model.addAttribute("message", message);
                return modelAndView;
            }
        } else {
            message = "Please, fill in all fields";
            modelAndView.setViewName("exception");
            model.addAttribute("message", message);
            return modelAndView;
        }
    }
    @RequestMapping(value = {"/setRating"}, method = RequestMethod.GET)
    public ModelAndView getRatingsPage(Model model){
        ModelAndView modelAndView = new ModelAndView("ratings");
        RatingForm ratingForm = new RatingForm();
        List<Subject> subjects = subjectService.findAllSubjects();
        List<Student> students = studentService.findAllStudents();
        model.addAttribute("ratingForm", ratingForm);
        model.addAttribute("subjects", subjects);
        model.addAttribute("students", students);

        return modelAndView;
    }
}
