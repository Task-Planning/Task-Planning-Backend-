package com.example.task_planning.controller;

import com.example.task_planning.entity.TeamMember;
import com.example.task_planning.repository.TeamMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/teams")
@RequiredArgsConstructor
public class TeamMemberController {

    private final TeamMemberRepository teamMemberRepository;

    // Invite member to team
    @PostMapping("/{teamId}/invite")
    public TeamMember inviteMember(@PathVariable Long teamId,
                                   @RequestBody TeamMember member){

        member.setTeamId(teamId);
        member.setJoinedAt(LocalDateTime.now());

        return teamMemberRepository.save(member);
    }

    // Get all members in a team
    @GetMapping("/{teamId}/members")
    public List<TeamMember> getTeamMembers(@PathVariable Long teamId){
        return teamMemberRepository.findByTeamId(teamId);
    }

    // Remove member from team
    @DeleteMapping("/{teamId}/members/{id}")
    public void removeMember(@PathVariable Long id){
        teamMemberRepository.deleteById(id);
    }

}