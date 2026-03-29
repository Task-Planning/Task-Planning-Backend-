package com.example.task_planning.controller;

import com.example.task_planning.entity.Team;
import com.example.task_planning.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/teams")
@RequiredArgsConstructor
public class TeamController {

    private final TeamRepository teamRepository;

    @PostMapping
    public Team createTeam(@RequestBody Team team){

        team.setCreatedAt(LocalDateTime.now());

        return teamRepository.save(team);
    }

    @GetMapping
    public List<Team> getTeams(){
        return teamRepository.findAll();
    }

    @GetMapping("/{id}")
    public Team getTeam(@PathVariable Long id){
        return teamRepository.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Team updateTeam(@PathVariable Long id,
                           @RequestBody Team team){

        Team existing = teamRepository.findById(id).orElseThrow();

        existing.setName(team.getName());
        existing.setDescription(team.getDescription());

        return teamRepository.save(existing);
    }

    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable Long id){
        teamRepository.deleteById(id);
    }

}