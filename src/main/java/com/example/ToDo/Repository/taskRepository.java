package com.example.ToDo.Repository;

import com.example.ToDo.Models.task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface taskRepository extends JpaRepository<task,Integer> {

}
