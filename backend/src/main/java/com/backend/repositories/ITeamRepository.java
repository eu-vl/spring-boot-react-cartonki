package com.backend.repositories;

import com.backend.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITeamRepository extends JpaRepository<Team, Long> {
    Team findTeamById(Long id);

    Team findTeamByTitle(String title);
}
