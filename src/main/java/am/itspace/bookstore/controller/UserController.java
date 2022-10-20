package am.itspace.bookstore.controller;

import am.itspace.bookstore.entity.User;
import am.itspace.bookstore.exception.DublicateResourceException;
import am.itspace.bookstore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user/verify")
    public String verifyUser(@RequestParam("email") String email,
                             @RequestParam("token") String token) throws Exception {
        userService.verifyUser(email,token);
        return "redirect:/";
    }

    @GetMapping("/register")
    public String registerPage(){
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user) throws DublicateResourceException {
        userService.save(user);
        return "redirect:/";
    }


}
