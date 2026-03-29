package com.example.task_planning.dto.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CreateTaskRequest {

    private String title;

    private String description;

    private String type;

    private Long teamId;

    private String priority;

    private LocalDateTime deadline;

}