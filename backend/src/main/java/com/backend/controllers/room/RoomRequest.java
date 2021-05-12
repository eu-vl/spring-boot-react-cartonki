package com.backend.controllers.room;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class RoomRequest {
    @NotEmpty
    private String RoomTitle;

    private Long team_id;

    private Long RoomLead_id;

    public RoomRequest() {
    }

    public String getTitle() {
        return RoomTitle;
    }

    public void setTitle(String title) {
        this.RoomTitle = title;
    }

    public Long getTeam_id() {
        return team_id;
    }

    public void setTeam_id(Long team_id) {
        this.team_id = team_id;
    }

    public Long getLead_id() {
        return RoomLead_id;
    }

    public void setLead_id(Long lead_id) {
        this.RoomLead_id = lead_id;
    }
}
