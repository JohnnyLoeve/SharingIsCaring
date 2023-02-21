package com.example.SharingIsCaring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @Autowired
    UserRepo createUserRepo;

    //GetMapping for HomePage
    @GetMapping("/")
    public String mainPage(){

        return"MainPage";
    }

    //GetMapping for CreateUser
    @GetMapping("/CreateUser")
    public String createUser(Model model){
        model.addAttribute("CreateUser", new User());
        return "CreateUser";
    }
//    PostMapping for CreateUser
    @PostMapping("/CreateUser")
    public  String createUser(@ModelAttribute User createUser){
    createUserRepo.save(createUser);
        return "redirect:/Account";
    }

    //GetMapping for Login
    @GetMapping("/LoginPage")
    public String loginPage(){

        return "LoginPage";
    }

    //@PostMapping("/LoginPage")
    @PostMapping("/LoginPage")
    public String loginSucces(){

        return "/";
    }

//    public String Login(){
//    }
    //GetMapping for Logout


    //GetMapping for Account
    @GetMapping("/Account")
    public String account (){

        return "Account";
    }


    //(Use an "id" to get the propper user, and/or meal)


    //GetMapping for MealOptions
    @GetMapping("/MealOptions")
    public String mealOptions (){

        return "MealOptions";
    }

    //@GetMapping("/ContactForm")
    @GetMapping("/ContactForm")
    public String showForm(Model model) {
    User user = new User();
    model.addAttribute("user", user);
        return "ContactForm";
    }

    //@PostMapping("/ContactForm")
    @PostMapping("/ContactForm")
    public String submitForm(@ModelAttribute("user") User user) {
        System.out.println(user);
        return "redirect:/";
    }


    //GetMapping for CreateAMeal

    //PostMapping for CreateAMeal (for at gemme måltidet)

    //GetMapping for EditMeal

    //PostMapping for EditMeal (Eller bare gøre brug af postmapping fra create a meal)

    //GetMapping for DeleteAMeal


}
