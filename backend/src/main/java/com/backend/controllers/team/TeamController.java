package com.backend.controllers.team;

import com.backend.models.Team;
import com.backend.models.User;
import com.backend.services.TeamService;
import com.backend.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("team")
public class TeamController {
    private final TeamService teamService;
    private final UserService userService;

    public TeamController(TeamService teamService, UserService userService) {
        this.teamService = teamService;
        this.userService = userService;
    }

    @PostMapping("create")
    public ResponseEntity<String> create(@Valid TeamRequest teamRequest) {
        Long userId = teamRequest.getUserId();
        teamService.saveTeam(teamRequest, userId);
        return ResponseEntity.ok(new TeamResponse().build(teamRequest.getTeamTitle()));
    }

    @PostMapping("add-user")
    public ResponseEntity<String> addUser(@Valid TeamRequest teamRequest) {
        Team curTeam = teamService.getTeamByTitle(teamRequest.getTeamTitle());
        teamService.addUserToTeam(curTeam, userService.getUserById(teamRequest.getUserId()));
        return ResponseEntity.ok(new TeamResponse().build(teamRequest.getTeamTitle()));
    }

    @GetMapping("get-all")
    public List<Team> getAllTeams(){
        return teamService.getAllTeams();
    }
}
