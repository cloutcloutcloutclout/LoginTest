package com.example.logintest.Controller;

import com.example.logintest.Model.User;
import com.example.logintest.Repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


/*
TBD
* Statements to check the Users USERNAME, PASSWORD can be whatever for now
* WORKING LOGIN and redirect to /home, probably need /home
 */





@Controller
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    /*
    Auth Controller holds the index "/"
    Can only be used for authentication, specifically the login and register segment of a website
     */
    @GetMapping("/")
    public String root() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }













    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user", new User());
        return "register"; // register jsp
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user, BindingResult result){

        /*
        Logic,
        * Username cannot be an existing username
        * Password can be anything though cuz we're using long it can store a wide range.
        probably
        if(User.username = userRepository.findBy(Username) ? exists??
         */

        // username needs to be unique
        if (userRepository.findByUsername(user.getUsername()).isPresent()){
            result.rejectValue("username", "usernameError", "Username exists");
        }

        // if any errors just go back
        if (result.hasErrors()){
            return "register";
        }

        // bcrypt password
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // final part to save this user into the database as well a new user
        userRepository.save(user);
        // return for register to /login or /home don't know yet
        return "redirect:/login";
    }










}

