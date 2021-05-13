package com.backend.controllers.room;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class RoomResponse {
    @NotEmpty
    private String title;

    private Long teamId;

    private Long roomLeadId;


    public RoomResponse() {
    }

    public String build(String title) {
        return String.format("Room with name '%s' has been created", title);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
