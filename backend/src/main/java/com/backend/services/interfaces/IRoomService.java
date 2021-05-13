package com.backend.services.interfaces;

import com.backend.controllers.room.RoomRequest;
import com.backend.controllers.team.TeamRequest;
import com.backend.models.Room;
import com.backend.models.Team;
import com.backend.models.User;

import java.util.List;

public interface IRoomService {
    boolean saveRoom(RoomRequest roomRequest, Long teamId, User lead);

    boolean saveRoomWithTeam(RoomRequest roomRequest, TeamRequest teamRequest, Long userId, User lead);

    List<Room> getAllRooms();

    Room getRoomByTitle(String title);

    boolean deleteRoomByTitle(String title);
}
