package com.example.ToDo.Controller;

import com.example.ToDo.Models.task;
import com.example.ToDo.Services.ToDoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/tasks")
public class taskController {

    @Autowired
    private ToDoServices services;

    @GetMapping
    public String getTask(Model model)
    {
        List<task> tasks=services.getAllTasks();
        model.addAttribute("tasks",tasks);
        return "tasks";
    }

    @PostMapping
    public String createTask(@RequestParam String title)
    {
       services.createTask(title);
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable int id)
    {
       services.DeleteTasks(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/toggle")
    public String ToggleTask(@PathVariable int id) throws IllegalAccessException {
        services.ToggleTasks(id);
        return "redirect:/";
    }
}
