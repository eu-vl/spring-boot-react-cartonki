package com.backend.controllers.team;

import com.backend.models.User;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
public class TeamResponse {
    @NotEmpty
    private String title;

    private Long userId;


    public TeamResponse() {
    }

    public String build(String title) {
        return String.format("Team with name '%s' has been created", title);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
