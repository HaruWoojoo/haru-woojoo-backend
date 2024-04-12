package com.example.demo.user;

import com.example.demo.user.dto.UserCreateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")
@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    @ResponseBody
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public User getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @PostMapping("")
    @ResponseBody
    public User createUser(@RequestBody UserCreateDto dto) {
        User user = new User();
        user.setName(dto.getName());
        return userService.register(user);
    }
}
