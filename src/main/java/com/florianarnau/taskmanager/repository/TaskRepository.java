package com.florianarnau.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.florianarnau.taskmanager.model.Task;

/**
 * TaskRepository
 */
public interface TaskRepository extends JpaRepository<Task, Long> {
    
}