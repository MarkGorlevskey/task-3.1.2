package com.gorlevskey.task_31._spring_boot.controller;

import com.gorlevskey.task_31._spring_boot.model.User;
import com.gorlevskey.task_31._spring_boot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    public String getAllUsers(Model model) {
        List<User> userList = userService.findAll();
        model.addAttribute("userList", userList);
        return "index";
    }

    @GetMapping("/search")
    public String getUserById(@RequestParam(required = false) int id, Model model) {
        User user = userService.findById(id);
        if (user == null) {
            return "redirect:/";
        }
        model.addAttribute("user", user);
        return "search";
    }

    @GetMapping("/new")
    public String showCreateUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "new_user";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditUserForm(@PathVariable int id, Model model) {
        User user = userService.findById(id);
        if (user == null) {
            return "redirect:/";
        }
        model.addAttribute("user", user);
        return "edit_user";
    }

    @PatchMapping("/edit/{id}")
    public String updateUserSubmit(@PathVariable int id, @ModelAttribute User user) {
        userService.update(user, id);
        return "redirect:/";
    }



    @DeleteMapping("/delete/{id}")
    public String deleteUserSubmit(@PathVariable int id) {
        userService.deleteById(id);
        return "redirect:/";
    }
}