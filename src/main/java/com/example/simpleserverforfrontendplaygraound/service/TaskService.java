package com.example.simpleserverforfrontendplaygraound.service;

import com.example.simpleserverforfrontendplaygraound.dto.TaskDto;

import java.util.List;

public interface TaskService {
    TaskDto save(TaskDto requestDto);

    List<TaskDto> getAll();

    TaskDto deleteTaskById(Long id);

    TaskDto updateTask(TaskDto taskDto);
}
