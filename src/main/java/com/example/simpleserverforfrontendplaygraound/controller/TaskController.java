package com.example.simpleserverforfrontendplaygraound.controller;

import com.example.simpleserverforfrontendplaygraound.dto.TaskDto;
import com.example.simpleserverforfrontendplaygraound.service.TaskService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/add")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<TaskDto> addTask(@RequestBody TaskDto requestDto) {
        TaskDto responceDto = taskService.save(requestDto);
//        HttpHeaders header = new HttpHeaders();

//        header.put("Access-Control-Allow-Origin", List.of("http://localhost:4200"));
        return new ResponseEntity<>(responceDto, HttpStatus.CREATED);
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:4200")
    ResponseEntity<List<TaskDto>> getAll() {
        List<TaskDto> result = taskService.getAll();
//        HttpHeaders header = new HttpHeaders();
//        header.put("Access-Control-Allow-Origin", List.of("http://localhost:4200"));
        ResponseEntity<List<TaskDto>> response = new ResponseEntity<>(result, HttpStatus.OK);
        return response;
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    ResponseEntity<TaskDto> deleteTaskById(@PathVariable Long id) {
        TaskDto taskDto = taskService.deleteTaskById(id);
//        HttpHeaders header = new HttpHeaders();
//        header.put("Access-Control-Allow-Origin", List.of("http://localhost:4200"));
        if (taskDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(taskDto, HttpStatus.OK);
    }

    @PutMapping
    @CrossOrigin(origins = "http://localhost:4200")
    ResponseEntity<TaskDto> updateTask(@RequestBody TaskDto taskDto) {
        TaskDto dto = taskService.updateTask(taskDto);
//        HttpHeaders header = new HttpHeaders();
//        header.put("Access-Control-Allow-Origin", List.of("http://localhost:4200"));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

}
