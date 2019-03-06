package hello.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/hola")
public class AccountController {

    @GetMapping("/{id}/favorites")
    public String login(@PathVariable String id) {
        return "login";
    }

    @GetMapping("/create")
    public String vvggvgv() {
        return "rgvvggvgvvg";
    }

    @GetMapping("/myAccount")
    public String myAccount() {
        return "myAccount";
    }

    @GetMapping("/myAccountUpdate")
    public String myAccountUpdate() {
        return "myAccountUpdate";
    }

    @GetMapping("/serchResults")
    public String serchResults() {
        return "serchResults";
    }
}