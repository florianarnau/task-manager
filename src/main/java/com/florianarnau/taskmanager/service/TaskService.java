package com.florianarnau.taskmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.florianarnau.taskmanager.model.Task;
import com.florianarnau.taskmanager.repository.TaskRepository;

@Service
public class TaskService {
    
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task addTask(Task task){
        return taskRepository.save(task);
    }
}
