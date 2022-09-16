package com.example.pp_3_1_1.crud.controller;

import com.example.pp_3_1_1.crud.model.User;
import com.example.pp_3_1_1.crud.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@Validated
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/add")
    public String addPage() {
        return "/addPage";
    }

    @PostMapping(value = "/add")
    public String addNewUser(@RequestParam(value = "name") String name,
                             @RequestParam(value = "lastName") String lastName,
                             @RequestParam(value = "email") String email,
                             @RequestParam(value = "password") String password) {
        userService.add(new User(name, lastName, email, password));
        return "redirect:/users";
    }

    @GetMapping("/users")
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getUsers(ModelMap modelMap){
        modelMap.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @PostMapping("/users")
    public String getAllUsers(ModelMap modelMap){
        modelMap.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @PostMapping(value = "users/edit")
    public String editUser(@ModelAttribute User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @GetMapping(value = "users/edit/{id}")
    public String EditUserById(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "/edit";
    }
    @GetMapping(value = "users/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/users";
    }
}