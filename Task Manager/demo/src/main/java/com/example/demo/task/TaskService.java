package com.example.demo.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasks()
    {
        return taskRepository.findAll();
    }

    public void addNewTask(Task task) {
        Optional<Task> taskOptional = taskRepository
                .findTaskByName(task.getName());
        if (taskOptional.isPresent())
        {
            throw new IllegalStateException("Task already present");
        }
        taskRepository.save(task);
    }
}
