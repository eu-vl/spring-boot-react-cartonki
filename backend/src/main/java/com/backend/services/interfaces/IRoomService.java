package com.backend.services.interfaces;

import com.backend.controllers.room.RoomRequest;
import com.backend.controllers.team.TeamRequest;
import com.backend.models.Room;
import com.backend.models.Team;
import com.backend.models.User;

import java.util.List;

public interface IRoomService {
    boolean saveRoom(RoomRequest room, Long team_id, User lead);

    boolean saveRoomWithTeam(RoomRequest r, TeamRequest tr, Long user_id, User lead);

    List<Room> getAllRooms();

    Room getRoomByTitle(String title);

    boolean deleteRoomByTitle(String title);
}
