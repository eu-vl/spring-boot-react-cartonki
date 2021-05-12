package com.backend.services;

import com.backend.models.Room;
import com.backend.repositories.IRoomRepository;
import com.backend.services.interfaces.IRoomService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService implements IRoomService {
    private final IRoomRepository iRoomRepository;

    public RoomService(IRoomRepository iRoomRepository) {
        this.iRoomRepository = iRoomRepository;
    }

    @Override
    public boolean createRoom(Room room) {
        Room roomDb=iRoomRepository.findRoomByTitle(room.getTitle());
        if (roomDb!=null){
            return false;
        }
         iRoomRepository.save(room);
        return true;
    }

    @Override
    public List<Room> getAllRoles() {
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
