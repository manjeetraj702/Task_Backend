package com.example.taskmanger.service.impl;

import com.example.taskmanger.model.Task;
import com.example.taskmanger.repository.TaskRepository;
import com.example.taskmanger.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskRepository taskRepository;
    @Override
    public Task createTask(Task task) {

        return taskRepository.save(task);
    }
}
