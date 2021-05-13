package com.backend.services;

import com.backend.controllers.team.TeamRequest;
import com.backend.models.Role;
import com.backend.models.Team;
import com.backend.models.User;
import com.backend.repositories.ITeamRepository;
import com.backend.repositories.IUserRepository;
import com.backend.services.interfaces.ITeamService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TeamService implements ITeamService {
    private final ITeamRepository iTeamRepository;
    private final IUserRepository iUserRepository;

    public TeamService(ITeamRepository iTeamRepository, IUserRepository iUserRepository) {
        this.iTeamRepository = iTeamRepository;
        this.iUserRepository = iUserRepository;
    }

    @Override
    public boolean saveTeam(TeamRequest team, Long userId, User lead) {
        Team curTeam = new Team();
        User curUser = iUserRepository.findUserById(userId);
        curTeam.setLead(curUser);
        curTeam.setTitle(team.getTeamTitle());
        iTeamRepository.save(curTeam);
        curTeam = iTeamRepository.findTeamByTitle(team.getTeamTitle());
        addUserToTeam(curTeam, curUser);
        return iTeamRepository.findTeamByTitle(team.getTeamTitle()) != null;
    }

    @Override
    public Team getTeamByTitle(String title) {
        return iTeamRepository.findTeamByTitle(title);
    }

    @Override
    public Team getTeamById(Long id) {
        return iTeamRepository.findTeamById(id);
    }

    @Override
    public List<Team> getAllTeams() {
        return iTeamRepository.findAll();
    }

    public void addUserToTeam(Team team, User user) {
        List<Team> teamSet = new ArrayList<>();
        teamSet.add(team);
        user.setTeams(teamSet);
        iTeamRepository.save(team);
    }
}
