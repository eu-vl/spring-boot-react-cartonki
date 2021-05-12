package com.backend.controllers.team;

import com.backend.models.User;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
public class TeamResponse {
    @NotEmpty
    private String title;

    private Long user_id;


    public TeamResponse() {
    }

    public TeamResponse build(String title, Long user_id) {
        TeamResponse response = new TeamResponse();
        response.title = title;
        response.user_id = user_id;
        return response;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
