package com.example.simpleserverforfrontendplaygraound.service.impl;

import com.example.simpleserverforfrontendplaygraound.dto.TaskDto;
import com.example.simpleserverforfrontendplaygraound.entity.Task;
import com.example.simpleserverforfrontendplaygraound.repository.TaskRepository;
import com.example.simpleserverforfrontendplaygraound.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final ModelMapper mapper;

    public TaskServiceImpl(TaskRepository taskRepository, ModelMapper mapper) {
        this.taskRepository = taskRepository;
        this.mapper = mapper;
    }


    @Override
    public TaskDto save(TaskDto requestDto) {
        Task task = taskRepository.save(mapper.map(requestDto, Task.class));
        return mapper.map(task, TaskDto.class);
    }

    @Override
    public List<TaskDto> getAll() {
        List<Task> tasks = taskRepository.getAllByReminderTrueOrReminderFalse();
        return tasks.stream().map(t -> mapper.map(t, TaskDto.class)).collect(Collectors.toList());
    }

    @Override
    public TaskDto deleteTaskById(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()) {
            taskRepository.deleteById(task.get().getId());
            return mapper.map(task.get(), TaskDto.class);
        } else {
            return null;
        }

    }

    @Override
    public TaskDto updateTask(TaskDto taskDto) {
        Optional<Task> toEdit = taskRepository.findById(taskDto.getId());
        if (toEdit.isEmpty()) {
            return null;
        }
        Task task = toEdit.get();
        task.setText(taskDto.getText())
                .setDay(taskDto.getDay())
                .setReminder(taskDto.isReminder());
        taskRepository.save(task);
        return mapper.map(task, TaskDto.class);
    }
}
