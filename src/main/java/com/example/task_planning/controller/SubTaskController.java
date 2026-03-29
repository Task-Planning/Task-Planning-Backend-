package com.example.task_planning.controller;

import com.example.task_planning.entity.SubTask;
import com.example.task_planning.entity.Task;
import com.example.task_planning.repository.SubTaskRepository;
import com.example.task_planning.repository.TaskRepository;
import com.example.task_planning.dto.request.SubTaskRequest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SubTaskController {

    private final SubTaskRepository subtaskRepository;
    private final TaskRepository taskRepository;

    // Create Subtask
    @PostMapping("/tasks/{taskId}/subtasks")
    public SubTask createSubtask(
            @PathVariable Long taskId,
            @RequestBody SubTaskRequest request){

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        SubTask subtask = SubTask.builder()
                .title(request.getTitle())
                .startDateTime(request.getStartDateTime())
                .endDateTime(request.getEndDateTime())
                .isCompleted(false)
                .createdAt(LocalDateTime.now())
                .task(task)
                .build();

        return subtaskRepository.save(subtask);
    }

    // Get subtasks by task
    @GetMapping("/tasks/{taskId}/subtasks")
    public List<SubTask> getSubtasks(@PathVariable Long taskId){
        return subtaskRepository.findByTaskId(taskId);
    }

    // Update subtask
    @PutMapping("/subtasks/{id}")
    public SubTask updateSubtask(
            @PathVariable Long id,
            @RequestBody SubTaskRequest request){

        SubTask subtask = subtaskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subtask not found"));

        subtask.setTitle(request.getTitle());
        subtask.setStartDateTime(request.getStartDateTime());
        subtask.setEndDateTime(request.getEndDateTime());
        subtask.setUpdatedAt(LocalDateTime.now());

        return subtaskRepository.save(subtask);
    }

    // Complete subtask
    @PutMapping("/subtasks/{id}/complete")
    public SubTask toggleComplete(@PathVariable Long id){

        SubTask subtask = subtaskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subtask not found"));

        subtask.setIsCompleted(!subtask.getIsCompleted());

        return subtaskRepository.save(subtask);
    }

    // Delete subtask
    @DeleteMapping("/subtasks/{id}")
    public void deleteSubtask(@PathVariable Long id){
        subtaskRepository.deleteById(id);
    }
}