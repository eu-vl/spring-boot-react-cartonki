package com.backend.repositories;

import com.backend.models.Block;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlockRepository extends JpaRepository<Block,Long> {
    Block findBlockById(Long id);
    Block findBlockByTitle(String title);
}
