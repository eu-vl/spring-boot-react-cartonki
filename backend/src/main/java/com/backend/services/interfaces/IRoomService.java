package com.backend.services.interfaces;

import com.backend.models.Room;

import java.util.List;

public interface IRoomService {
    boolean createRoom(Room room);

    List<Room> getAllRoles();

    Room getRoomByTitle(String title);

    boolean deleteRoomByTitle(String title);
}
