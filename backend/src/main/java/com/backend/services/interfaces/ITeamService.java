package com.backend.services.interfaces;

import com.backend.controllers.team.TeamRequest;
import com.backend.models.Team;
import com.backend.models.User;

import java.util.List;

public interface ITeamService {
    boolean saveTeam(TeamRequest team, Long user_id, User lead);
    Team getTeamByTitle(String title);
    Team getTeamById(Long id);
    List<Team> getAllTeams();
}
