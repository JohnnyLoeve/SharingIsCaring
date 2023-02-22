package com.example.SharingIsCaring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @Autowired
    UserRepo userRepo;

    //GetMapping for HomePage
    @GetMapping("/HomePage")
    public String mainPage(Model model){
    UserProfile userProfile = new UserProfile(3L, "Dude", "Duden", "123", "ADMIN");
        model.addAttribute("userProfile", userProfile);
        return"HomePage";
    }

    //GetMapping for CreateUser
    @GetMapping("/CreateUser")
    public String createUser(Model model){
        model.addAttribute("CreateUser", new UserProfile());
        return "CreateUser";
    }
//    PostMapping for CreateUser
    @PostMapping("/CreateUser")
    public  String createUser(@ModelAttribute UserProfile createUser){
    userRepo.save(createUser);
        return "redirect:/Account";
    }

    //GetMapping for Login
    @GetMapping("/LoginPage")
    public String loginPage(){
//    model.addAttribute("userProfile", userProfile);
        return "LoginPage";
    }

    //@PostMapping("/LoginPage")
//    @PostMapping("/LoginPage")
//    public String login(Model model, @ModelAttribute UserProfile userProfile){
//        System.out.println(userRepo.login(userProfile.getUsername(), userProfile.getPassword()));
//        System.out.println(userProfile);
//        return "/HomePage";
//    }

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
    UserProfile user = new UserProfile();
    model.addAttribute("user", user);
        return "ContactForm";
    }

    //@PostMapping("/ContactForm")
    @PostMapping("/ContactForm")
    public String submitForm(@ModelAttribute("user") UserProfile user) {
        System.out.println(user);
        return "redirect:/";
    }


    //GetMapping for CreateAMeal

    //PostMapping for CreateAMeal (for at gemme måltidet)

    //GetMapping for EditMeal

    //PostMapping for EditMeal (Eller bare gøre brug af postmapping fra create a meal)

    //GetMapping for DeleteAMeal


}
