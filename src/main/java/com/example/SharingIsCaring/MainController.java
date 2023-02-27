package com.example.SharingIsCaring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.sql.SQLOutput;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    UserRepo userRepo;

    @Autowired
    MealRepo mealRepo;

    //GetMapping for HomePage
    @GetMapping("/HomePage")
    public String mainPage(Model model){
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
    @PostMapping("/CreateUser/saveUser")
    public  String CreateUser(@ModelAttribute UserProfile userProfile){
        System.out.println("Trying to create user");
        userRepo.save(userProfile);
        return "/HomePage";
    }

//    @GetMapping("/CreateAMeal")
//    public String createAMeal(Model model){
//        model.addAttribute("CreateAMeal", new Meal());
//        return "/CreateAMeal";
//    }
//    //PostMapping for CreateAMeal (for at gemme måltidet)
//    @PostMapping("/CreateAMeal/saveMeal")
//    public String createAMeal(@ModelAttribute Meal meal){
//        mealRepo.save(meal);
//        return "/MealOptions";
//    }

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
        Optional<UserProfile> user = userRepo.findById(2L);
        model.addAttribute("userProfile", user.get());
            return "Account";

//        System.out.println("Trying to return UserProfile");
//        model.addAttribute("userProfile", userRepo.findUserById(new BigInteger("1")));


    }

    @GetMapping("/MealOptions")
    public String mealOptions (Model model){
        List<Meal> meal = (List)mealRepo.findAll();
        model.addAttribute("meal", meal);
        System.out.println("Trying to return meals");
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
    @PostMapping("/CreateAMeal/saveMeal")
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
