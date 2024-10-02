package com.example.taskmanger.service;

import com.example.taskmanger.model.Task;
import com.example.taskmanger.model.User;
import com.example.taskmanger.model.request.AddTask;
import com.example.taskmanger.model.request.CreateUser;
import com.example.taskmanger.model.request.DeleteTask;
import com.example.taskmanger.model.request.SignInUser;

import java.util.List;

public interface UserService {
    User createUser(CreateUser createUser);

    User signIn(SignInUser signInUser);

    User addTask(AddTask addTask);

    User deleteTask(DeleteTask deleteTask);

    List<Task> getListOfTask(String userId);

    List<User> getUsers();

}
