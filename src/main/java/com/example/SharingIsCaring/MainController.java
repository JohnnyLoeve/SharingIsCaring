package com.example.SharingIsCaring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.sql.SQLOutput;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    UserRepo userRepo;

    @Autowired
    MealRepo mealRepo;

    //GetMapping for HomePage
    @GetMapping("/HomePage")
    public String mainPage(Model model){
    UserProfile userProfile = new UserProfile(3L, "Dude", "Duden", "123", "ADMIN");
        model.addAttribute("userProfile", userProfile);
        return"HomePage";
    }

    //GetMapping for CreateUser
    @GetMapping("/CreateUser")
    public String CreateUser(Model model){
        model.addAttribute("CreateUser", new UserProfile());
        System.out.println("creating user");
        return "CreateUser";
    }
//    PostMapping for CreateUser
    @PostMapping("/save")
    public  String CreateUser(@ModelAttribute UserProfile CreateUser){
        System.out.println("Trying to create user");
        userRepo.save(CreateUser);
        return "/HomePage";
    }

    //GetMapping for Login
    @GetMapping("/LoginPage")
    public String loginPage(Model model, @ModelAttribute UserProfile userProfile){
    model.addAttribute("userProfile", userProfile);
        return "LoginPage";
    }


    @PostMapping("/LoginPage")
    public String login(Model model, @ModelAttribute UserProfile userProfile){
       userRepo.login(userProfile.getUsername(), userProfile.getPassword());
        return "/HomePage";
    }

//    public String Login(){
//    }
    //GetMapping for Logout


    //GetMapping for Account
    @GetMapping("/Account")
    public String account (Model model){
//        List<Meal> meals = (List)mealRepo.findAll();
//        model.addAttribute("meals", meals);
        return "Account";
    }


    //(Use an "id" to get the propper user, and/or meal)


    //GetMapping for MealOptions
    @GetMapping("/MealOptions")
    public String mealOptions (Model model){
//        List<Meal> meals = (List)mealRepo.findAll();
//        model.addAttribute("meals", meals);
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
    @GetMapping("/CreateAMeal")
    public String createAMeal(Model model){
        model.addAttribute("CreateAMeal", new Meal());
        return "/CreateAMeal";
    }
    //PostMapping for CreateAMeal (for at gemme måltidet)
    @PostMapping("/CreateAMeal")
    public String createAMeal(@ModelAttribute Meal meal){
    mealRepo.save(meal);
    return "/MealOptions";
    }


    //GetMapping for EditMeal

    //PostMapping for EditMeal (Eller bare gøre brug af postmapping fra create a meal)
//    @GetMapping("/meals/edit/{Id}")
//    public String editMeal(@PathVariable Long id) {
//        mealRepo.save(mealRepo.findById(id));
//        return "redirect:/MealOptions";
//    }
    //GetMapping for DeleteAMeal
//    @GetMapping("/meals/delete/{Id}")
//    public String deleteMeal(@PathVariable Long id) {
//        mealRepo.delete(mealRepo.findById(id));
//        return "redirect:/MealOptions";
//    }


}
