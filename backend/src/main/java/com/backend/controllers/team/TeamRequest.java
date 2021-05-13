package com.backend.controllers.team;

import com.backend.models.User;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class TeamRequest {
    @NotEmpty
    private String teamTitle;

    private Long userId;

    private Long teamLeadId;

    public TeamRequest() {
    }

    public String getTeamTitle() {
        return teamTitle;
    }

    public void setTeamTitle(String teamTitle) {
        this.teamTitle = teamTitle;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTeamLeadId() {
        return teamLeadId;
    }

    public void setTeamLeadId(Long teamLeadId) {
        this.teamLeadId = teamLeadId;
    }
}
