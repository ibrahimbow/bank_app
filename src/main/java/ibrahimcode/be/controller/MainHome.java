package ibrahimcode.be.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainHome {

    @GetMapping("/")
    public String homePage(){
        return "index";
    }


}
