package hello;

import com.google.gson.Gson;
import hello.database.entities.AccountEntity;
import hello.database.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;
import static org.springframework.web.bind.annotation.RequestMethod.GET;


@Controller
public class GreetingController {
    @Autowired
    AccountRepository repository;

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


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/ex1")
    @ResponseBody
    public  String getFoosOrBarsByPath() {
        List<AccountEntity> pruebita = repository.findAll();
        return new Gson().toJson(pruebita);
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    @RequestMapping("/search")
//    public Page search(@RequestParam(value = "showType",required = false) String[] showType,
//                       @RequestParam(value = "status",required = false) String[] status,
//                       @RequestParam(value = "ageRating",required = false) String[] ageRating)throws  Exception{
//
//        System.out.println(Arrays.toString(showType));
//        System.out.println(Arrays.toString(ageRating));
//        System.out.println(Arrays.toString(status));
//
//        return searchManager.requestSearch(showType,status,ageRating);
//    }
//    public Page requestSearch(String[] streamerChecksArray, String[] genreChecksArray) throws Exception {
//    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//
//    @RequestMapping("/prueba")
//    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
//        return new Greeting(counter.incrementAndGet(),
//                String.format(template, name));
//    }
//    @Controller
//    @RequestMapping("/users")
//    public class UserController {
//
//        @RequestMapping("/{id}")
//        public String showUserForm(@PathVariable("id") User user, Model model) {
//
//            model.addAttribute("user", user);
//            return "userForm";
//        }
//    }

}
