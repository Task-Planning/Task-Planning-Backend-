package com.example.task_planning.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    private TaskType type;

    private Long teamId;

    private Long createdBy;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;

    private LocalDateTime deadline;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public enum TaskType {
        PERSONAL,
        TEAM
    }

    public enum Priority {
        HIGH,
        MEDIUM,
        LOW
    }

    public enum Status {
        INCOMPLETE,
        IN_PROGRESS,
        COMPLETE
    }
}