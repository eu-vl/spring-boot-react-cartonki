package com.backend.repositories;

import com.backend.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoomRepository extends JpaRepository<Room, Long> {
    Room findRoomById(Long id);

    Room findRoomByTitle(String title);
}
