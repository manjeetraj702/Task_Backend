package com.example.taskmanger.controller;

import com.example.taskmanger.model.Task;
import com.example.taskmanger.model.User;
import com.example.taskmanger.model.request.AddTask;
import com.example.taskmanger.model.request.CreateUser;
import com.example.taskmanger.model.request.DeleteTask;
import com.example.taskmanger.model.request.SignInUser;
import com.example.taskmanger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1")
@RestController
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public User createUser(@RequestBody CreateUser createUser) {
        return userService.createUser(createUser);
    }

    @PostMapping("/signIn")
    public User signIn(@RequestBody SignInUser signInUser) {
        return userService.signIn(signInUser);
    }

    @PutMapping("/addTask")
    public User addTask(@RequestBody AddTask addTask) {
        return userService.addTask(addTask);
    }

    @PutMapping("/deleteTask")
    public User deleteTask(@RequestBody DeleteTask deleteTask) {
        return userService.deleteTask(deleteTask);
    }


    @GetMapping("/getListOfTask")
    public List<Task> getListOfTask(@RequestParam String userId) {
        return userService.getListOfTask(userId);
    }

    @GetMapping("users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

}
