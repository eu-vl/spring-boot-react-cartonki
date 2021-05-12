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
    public ResponseEntity<TeamResponse> create(@Valid TeamRequest teamRequest) {
        Long user_id = teamRequest.getUser_id();
        User lead = userService.getUserById(user_id);
        teamService.saveTeam(teamRequest, user_id, lead);
        return ResponseEntity.ok(new TeamResponse().build(teamRequest.getTitle(), teamRequest.getUser_id()));
    }

    @PostMapping("addUser")
    public ResponseEntity<TeamResponse> addUser(@Valid TeamRequest teamRequest) {
        Team curTeam = teamService.getTeamByTitle(teamRequest.getTitle());
        teamService.addUserToTeam(curTeam, userService.getUserById(teamRequest.getUser_id()));
        return ResponseEntity.ok(new TeamResponse().build(teamRequest.getTitle(), teamRequest.getUser_id()));
    }

    @GetMapping("getAll")
    public List<Team> getAllTeams(){
        return teamService.getAllTeams();
    }
}
