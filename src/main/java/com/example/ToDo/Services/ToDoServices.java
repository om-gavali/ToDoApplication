package com.example.ToDo.Services;

import com.example.ToDo.Models.task;
import com.example.ToDo.Repository.taskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoServices {
    @Autowired
    private taskRepository taskRepository;

    public List<task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void createTask(String title) {
        task task = new task();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepository.save(task);
    }

    public void DeleteTasks(int id) {
        taskRepository.deleteById(id);
    }

    public void ToggleTasks(int id) throws IllegalAccessException {
        task ts=taskRepository.findById(id).orElseThrow(()->new IllegalAccessException("Invalid Task Id"));
        ts.setCompleted(true);
        taskRepository.save(ts);
    }
}
