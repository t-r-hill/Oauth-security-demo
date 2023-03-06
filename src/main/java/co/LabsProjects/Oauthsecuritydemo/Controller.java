package co.LabsProjects.Oauthsecuritydemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private Service service;

//    @GetMapping("/")
//    public String showHome(){
//        return "index";
//    }

    @GetMapping("/protected")
    public String showHomeProtected(Authentication authentication){
        if (authentication != null) {
            System.out.println(authentication);
        }
        return "index";
    }

    @GetMapping("/")
    public String getProtectedPage(Authentication authentication) {
        if (authentication != null) {
            System.out.println(authentication);
        }
        return "index";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model){
        model.addAttribute("authUris", service.getClientRegistrations());
        return "login";
    }
}
