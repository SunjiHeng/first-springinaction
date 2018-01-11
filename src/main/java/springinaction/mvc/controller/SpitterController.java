package springinaction.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springinaction.mvc.basic.Spitter;

/**
 * @author HP
 * @create 2018-01-10-18:17
 */
@Controller
@RequestMapping("/spitter")
public class SpitterController {
    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute (new Spitter ());
        return "registerForm";
    }
}
