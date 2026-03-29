package com.example.task_planning.repository;

import com.example.task_planning.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {

    // find all teams created by a user
    List<Team> findByCreatedBy(Long userId);

}