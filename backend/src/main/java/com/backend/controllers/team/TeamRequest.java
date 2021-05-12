package com.backend.controllers.team;

import com.backend.models.User;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class TeamRequest {
    @NotEmpty
    private String TeamTitle;

    private Long user_id;

    private Long TeamLead_id;

    public TeamRequest() {
    }

    public String getTitle() {
        return TeamTitle;
    }

    public void setTitle(String title) {
        this.TeamTitle = title;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getLead_id() {
        return TeamLead_id;
    }

    public void setLead_id(Long lead_id) {
        this.TeamLead_id = lead_id;
    }
}
