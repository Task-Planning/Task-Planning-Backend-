
package com.example.task_planning.repository;

import com.example.task_planning.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

// import java.util.List;
public interface TaskRepository extends JpaRepository<Task, Long> {
    
}