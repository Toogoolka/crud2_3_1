package com.tugulev.crudApp.controller;
import com.tugulev.crudApp.model.User;
import com.tugulev.crudApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@Controller
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


//    ////////////////////////////////////REWRITE
    @GetMapping()
    public String sayHello(Model model) {
        model.addAttribute("hello", "helloWorld");
        return "index";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());

        return "users/new";
    }

    @GetMapping("/data")
    public String show(@RequestParam(value = "name", required = false) String name,
                       Model model) {
        if (name == null) {
            model.addAttribute("users", userService.findAll());
        } else {
            model.addAttribute("users", userService.findByName(name));
        }
        return "users/data";
    }
    @GetMapping("/users/{id}")
    public String showOne(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.findOne(id));
        return "users/user";
    }

    @PostMapping
    public String add(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/new";
        }

        userService.save(user);
        return "redirect:/data";
    }

    @PatchMapping("/users/{id}")
    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
                         @PathVariable("id") Long id) {
        if (bindingResult.hasErrors()) {
            return "users/user";
        }
        userService.update(id, user);
        return "redirect:/data";
    }

    @DeleteMapping("/users/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/data";
    }

}