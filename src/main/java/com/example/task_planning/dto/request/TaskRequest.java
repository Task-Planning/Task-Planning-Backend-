package com.example.task_planning.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskRequest {

    private String title;

    private String description;

    private String priority;   // HIGH, MEDIUM, LOW

    private String status;     // INCOMPLETE, IN_PROGRESS, COMPLETE

    private LocalDateTime deadline;

}