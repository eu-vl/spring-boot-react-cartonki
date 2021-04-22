package com.backend.repositories;

import com.backend.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITodoRepository extends JpaRepository<Todo, Long> {
    Todo findTodoById(Long id);

    Todo findTodoByTitle(String title);
}
