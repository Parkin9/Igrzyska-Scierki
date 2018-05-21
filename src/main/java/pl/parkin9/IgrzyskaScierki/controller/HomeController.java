package pl.parkin9.IgrzyskaScierki.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.parkin9.IgrzyskaScierki.model.Login;
import pl.parkin9.IgrzyskaScierki.model.PlayerGroup;
import pl.parkin9.IgrzyskaScierki.service.PlayerGroupService;
import pl.parkin9.IgrzyskaScierki.service.ValidationLoginService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class HomeController {

    private final PlayerGroupService playerGroupService;
    private final ValidationLoginService validationLoginService;

    @Autowired
    public HomeController(PlayerGroupService playerGroupService, ValidationLoginService validationLoginService) {
        this.playerGroupService = playerGroupService;
        this.validationLoginService = validationLoginService;
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/")
    public ModelAndView indexLoginForm(HttpSession sess) {

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("login", new Login());

        sess.invalidate();

        return modelAndView;
    }


    @PostMapping("/")
    public ModelAndView indexLogin(@Valid Login login, BindingResult bindingResult, HttpSession sess) {

        ModelAndView modelAndView = new ModelAndView();

        if(bindingResult.hasErrors()) {
            modelAndView.setViewName("index");
            return modelAndView;
        }

        PlayerGroup playerGroup = playerGroupService.findByName(login.getLoginName());
        if(validationLoginService.checkPassword(login)) {

            sess.setAttribute("loggedInPlayerGroup", playerGroup);
            modelAndView.setViewName("redirect:/panel");

            return modelAndView;

        } else {
            modelAndView.addObject("validErrorPass", "Złe hasło lub/i login");
            modelAndView.setViewName("index");

            return modelAndView;
        }
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/registration")
    public ModelAndView registrationForm() {
        ModelAndView modelAndView = new ModelAndView("form/registration");
        PlayerGroup playerGroup = new PlayerGroup();
        modelAndView.addObject("playerGroup", playerGroup);

        return modelAndView;
    }

    @PostMapping("/registration")
    public ModelAndView registration(@Valid PlayerGroup playerGroup, BindingResult bindingResult) {

        ModelAndView modelAndView = new ModelAndView();

        if(bindingResult.hasErrors()) {
            modelAndView.setViewName("form/registration");
            return modelAndView;
        }

        PlayerGroup playerGroupExists = playerGroupService.findByName(playerGroup.getName());
        if(playerGroupExists == null) {

            playerGroup.setPassword(BCrypt.hashpw(playerGroup.getPassword(), BCrypt.gensalt()));
            playerGroupService.savePlayerGroup(playerGroup);

            modelAndView.addObject("login", new Login());
            modelAndView.setViewName("redirect:/");
            return modelAndView;
        } else {
            modelAndView.addObject("message", "Konto o takiej nazwie już istnieje");
            modelAndView.setViewName("form/registration");
            return modelAndView;
        }
    }
}
