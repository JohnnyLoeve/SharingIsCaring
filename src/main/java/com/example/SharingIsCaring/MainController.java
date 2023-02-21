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
    CreateUserRepo createUserRepo;

    //GetMapping for HomePage
    @GetMapping("/")
    public String mainPage(){
        return"MainPage";
    }

    //GetMapping for CreateUser
    @GetMapping("/CreateUser")
    public String createUser(Model model){
        model.addAttribute("CreateUser", new CreateUser());
        return "CreateUser";
    }
//    PostMapping for CreateUser
    @PostMapping("/CreateUser")
    public  String createUser(@ModelAttribute CreateUser createUser){
    createUserRepo.save(createUser);
        return "redirect:/Account";
    }

    //GetMapping for Login
    @GetMapping("/LoginPage")
    public String loginPage(){
        return "LoginPage";
    }

    //PostMapping for Login
//    @PostMapping("/LoginPage")
//    public String Login(){
//    }
    //GetMapping for Logout

    @GetMapping("/Account")
    public String account (){
        return "Account";
    }

    //GetMapping for Account
    //(Use an "id" to get the propper user, and/or meal)


    //GetMapping for MealOptions


    //GetMapping for ContactForm
    //PostMapping for ContactForm


    //GetMapping for CreateAMeal

    //PostMapping for CreateAMeal (for at gemme måltidet)

    //GetMapping for EditMeal

    //PostMapping for EditMeal (Eller bare gøre brug af postmapping fra create a meal)

    //GetMapping for DeleteAMeal


}
