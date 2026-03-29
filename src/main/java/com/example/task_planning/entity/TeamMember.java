package com.example.task_planning.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "team_members")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeamMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long teamId;

    private Long userId;

    @Enumerated(EnumType.STRING)
    private Role role;

    private LocalDateTime joinedAt;

    public enum Role {
        OWNER,
        MEMBER
    }
}