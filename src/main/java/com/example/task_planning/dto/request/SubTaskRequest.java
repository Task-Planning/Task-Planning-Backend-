package com.example.task_planning.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SubTaskRequest {

    private String title;

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;

}