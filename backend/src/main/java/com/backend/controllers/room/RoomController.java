package com.backend.controllers.room;

import com.backend.controllers.team.TeamRequest;
import com.backend.models.User;
import com.backend.services.RoomService;
import com.backend.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("room")
public class RoomController {

    private final RoomService roomService;
    private final UserService userService;

    public RoomController(RoomService roomService, UserService userService) {
        this.roomService = roomService;
        this.userService = userService;
    }

    @PostMapping("create-with-team")
    public ResponseEntity<String> create(@Valid RoomRequest roomRequest, @Valid TeamRequest teamRequest) {
        Long user_id = teamRequest.getUserId();
        User lead = userService.getUserById(user_id);
        roomService.saveRoomWithTeam(roomRequest, teamRequest, user_id, lead);
        return ResponseEntity.ok(new RoomResponse().build(roomRequest.getRoomTitle()));
    }

    @PostMapping("create-without-team")
    public ResponseEntity<String> create(@Valid RoomRequest roomRequest) {
        User lead = userService.getUserById(roomRequest.getRoomLeadId());
        roomService.saveRoom(roomRequest, roomRequest.getTeamId(), lead);
        return ResponseEntity.ok(new RoomResponse().build(roomRequest.getRoomTitle()));
    }
}
