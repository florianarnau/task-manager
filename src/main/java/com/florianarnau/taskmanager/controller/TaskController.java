package com.florianarnau.taskmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.florianarnau.taskmanager.model.Task;
import com.florianarnau.taskmanager.repository.TaskRepository;
import com.florianarnau.taskmanager.service.TaskService;

@Controller
@RequestMapping("/tasks")
/**
 * TaskController
 */
public class TaskController {

    private final TaskService taskService;

    @Autowired 
    TaskRepository taskRepository;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String getTasks(Model model) {
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        model.addAttribute("newTask", new Task());
        return "tasks";
    }

    @PostMapping
    public String addTask(@ModelAttribute("newTask") Task newTask) {
        taskService.addTask(newTask);
        return "redirect:/tasks";
    }

    @GetMapping("/delete/{taskId}")
    public String deleteTask(@PathVariable Long taskId) {
        taskRepository.deleteById(taskId);
        return "redirect:/tasks";
    }
}