package com.example.task_planning.repository;

import com.example.task_planning.entity.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {

    // find all members in a team
    List<TeamMember> findByTeamId(Long teamId);

    // find all teams a user joined
    List<TeamMember> findByUserId(Long userId);

}