package com.example.SharingIsCaring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    //GetMapping for HomePage
    @GetMapping("/")
    public String mainPage(){
        return"MainPage";
    }
    //GetMapping for CreateUser

    //PostMapping for CreateUser


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
