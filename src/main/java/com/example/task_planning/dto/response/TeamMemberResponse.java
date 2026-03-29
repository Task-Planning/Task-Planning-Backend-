package com.example.task_planning.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TeamMemberResponse {

    private Long id;
    private Long userId;
    private Long teamId;
    private String role;

}