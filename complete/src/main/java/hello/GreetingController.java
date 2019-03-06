package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

//    @GetMapping("/greeting")
//    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
//        model.addAttribute("name", name);
//        return "greeting";
//    }
//    @GetMapping("/uno")
//    public String uno() {
//        return "uno";
//    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/create")
    public String create() {
        return "create";
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
