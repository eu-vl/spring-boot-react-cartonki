package com.backend.controllers.room;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class RoomRequest {
    @NotEmpty
    private String roomTitle;

    private Long teamId;

    private Long roomLeadId;

    public RoomRequest() {
    }

    public String getRoomTitle() {
        return roomTitle;
    }

    public void setRoomTitle(String roomTitle) {
        this.roomTitle = roomTitle;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Long getRoomLeadId() {
        return roomLeadId;
    }

    public void setRoomLeadId(Long roomLeadId) {
        this.roomLeadId = roomLeadId;
    }
}
