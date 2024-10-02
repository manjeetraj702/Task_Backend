package com.example.taskmanger.service.impl;

import com.example.taskmanger.model.Task;
import com.example.taskmanger.model.User;
import com.example.taskmanger.model.request.AddTask;
import com.example.taskmanger.model.request.CreateUser;
import com.example.taskmanger.model.request.DeleteTask;
import com.example.taskmanger.model.request.SignInUser;
import com.example.taskmanger.repository.UserRepository;
import com.example.taskmanger.service.TaskService;
import com.example.taskmanger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    TaskService taskService;

    @Override
    public User createUser(CreateUser createUser) {
        for (User user : userRepository.findAll()) {
            if (user.getUserName().equals(createUser.getUserName())) {
                return null;
            }
        }
        User user = new User();
        user.setUserName(createUser.getUserName());
        user.setPassword(createUser.getPassword());
        userRepository.save(user);
        return user;
    }

    @Override
    public User signIn(SignInUser signInUser) {
        for (User user : userRepository.findAll()) {
            if (user.getUserName().equals(signInUser.getUserName()) && user.getPassword().equals(signInUser.getPassword()))
                return user;
        }
        return null;
    }

    @Override
    public User addTask(AddTask addTask) {
        for (User user : userRepository.findAll()) {
            if (user.getId().equals(addTask.getUserId())) {
                Task task = new Task();
                task.setTitle(addTask.getTitle());
                task.setDescription(addTask.getDescription());
                task.setDueDate(LocalDate.now());
                user.getTaskList().add(taskService.createTask(task));
                userRepository.save(user);
                return user;
            }
        }
        return null;
    }

    @Override
    public User deleteTask(DeleteTask deleteTask) {
        for (User user : userRepository.findAll()) {
            if (user.getId().equals(deleteTask.getUserId())) {
                for (Task task : user.getTaskList()) {
                    if (task.getId().equals(deleteTask.getTaskId())) {
                        user.getTaskList().remove(task);
                        userRepository.save(user);
                        return user;

                    }
                }


            }
        }
        return null;
    }

    @Override
    public List<Task> getListOfTask(String userId) {

        for (User user : userRepository.findAll()) {
            if (user.getId().equals(userId)) {
                return user.getTaskList();
            }
        }
        return null;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
