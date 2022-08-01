package com.example.simpleserverforfrontendplaygraound.repository;

import com.example.simpleserverforfrontendplaygraound.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {



    List<Task> getAllByReminderTrueOrReminderFalse();

    Task getById(Long id);

    Optional<Task> findById(Long id);
}
