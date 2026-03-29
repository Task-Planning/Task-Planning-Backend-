package com.example.task_planning.dto.request;

import lombok.Data;

@Data
public class InviteMemberRequest {

    private Long userId;
    private String role;

}