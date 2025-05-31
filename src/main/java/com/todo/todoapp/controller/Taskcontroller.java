package com.todo.todoapp.controller;

import com.todo.todoapp.models.Task;
import com.todo.todoapp.services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping
public class Taskcontroller{
    private final TaskService taskservices;

    public Taskcontroller(TaskService taskservices){
        this.taskservices=taskservices;

    }
    @GetMapping
    public String getTask(Model model){
        List<Task> tasks=taskservices.getAllTasks();
        Object attributeName;
        model.addAttribute("tasks",tasks);
        return "tasks";
    }

    @PostMapping
    public String createTask(@RequestParam String title){
       taskservices.createtask(title);
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id){
       taskservices.deleteTask(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable Long id){
        taskservices.toggleTask(id);
        return "redirect:/";
    }
}
