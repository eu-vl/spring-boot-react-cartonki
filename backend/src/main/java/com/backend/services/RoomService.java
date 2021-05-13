package com.backend.services;

import com.backend.controllers.room.RoomRequest;
import com.backend.controllers.team.TeamRequest;
import com.backend.models.Room;
import com.backend.models.Team;
import com.backend.models.User;
import com.backend.repositories.IRoomRepository;
import com.backend.repositories.ITeamRepository;
import com.backend.services.interfaces.IRoomService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService implements IRoomService {
    private final IRoomRepository iRoomRepository;
    private final ITeamRepository iTeamRepository;
    private final TeamService teamService;
    public RoomService(IRoomRepository iRoomRepository, ITeamRepository iTeamRepository, TeamService teamService) {
        this.iRoomRepository = iRoomRepository;
        this.iTeamRepository = iTeamRepository;
        this.teamService = teamService;
    }


    @Override
    public boolean saveRoom(RoomRequest r, Long team_id, User lead) {
        Room room = new Room();
        Team curTeam = teamService.getTeamById(team_id);
        room.setTitle(r.getTitle());
        room.setLead(lead);
        room.setTeam(curTeam);
        iRoomRepository.save(room);
        return true;
    }

    @Override
    public boolean saveRoomWithTeam(RoomRequest r, TeamRequest tr, Long user_id, User lead) {
        Room room = new Room();
        teamService.saveTeam(tr, user_id, lead);
        Team team = teamService.getTeamByTitle(tr.getTitle());
        room.setTitle(r.getTitle());
        room.setLead(lead);
        room.setTeam(team);
        iRoomRepository.save(room);
        return true;
    }

    @Override
    public List<Room> getAllRooms() {
        return null;
    }

    @Override
    public Room getRoomByTitle(String title) {
        return null;
    }

    @Override
    public boolean deleteRoomByTitle(String title) {
        return false;
    }
}
