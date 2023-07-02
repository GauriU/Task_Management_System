package com.example.demo.task;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class TaskConfig {

    @Bean
    CommandLineRunner commandLineRunner(TaskRepository repository)
    {
        return args->{
          Task task1 =  new Task(
                    "Task 1",
                    "First task of the day",
                    LocalDate.of(2023, Month.JULY, 5),
                    "Completed"
            );
            Task task2 =  new Task(
                    "Task 2",
                    "Second task of the day",
                    LocalDate.of(2023, Month.JULY, 6),
                    "In Progress"
            );
            Task task3 =  new Task(
                    "Task 3",
                    "Third task of the day",
                    LocalDate.of(2023, Month.JULY, 7),
                    "Not Started"
            );
            repository.saveAll(
                    List.of(task1, task2, task3)
            );

        };
    }
}
