package com.assignment.tasktracker.controller;

import com.assignment.tasktracker.dto.TaskRequestDTO;
import com.assignment.tasktracker.dto.TaskResponseDTO;
import com.assignment.tasktracker.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    /*
    Resource to fetch all the tasks
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TaskResponseDTO> getAllTasks() {

        return taskService.getAllTasks();
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<TaskResponseDTO> getTaskById(@PathVariable Long taskId) {
        // Retrieve the Task entity by ID
        // Return ResponseEntity.ok(taskResponseDTO) if found, else return ResponseEntity.notFound().build()

        Optional<TaskResponseDTO> taskResponseDTO = taskService.getTaskById(taskId);

        return taskResponseDTO.map(dto ->
                        ResponseEntity.ok().body(dto))
                .orElseGet(() ->
                        ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TaskResponseDTO> createTask(@RequestBody TaskRequestDTO taskRequestDTO) {
        TaskResponseDTO response = taskService.createTask(taskRequestDTO);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<TaskResponseDTO> updateTask(@PathVariable Long taskId, @RequestBody TaskRequestDTO taskRequestDTO) {
        TaskResponseDTO response = taskService.createTask(taskRequestDTO);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity.HeadersBuilder<?> deleteTask(@PathVariable Long taskId) {
        // Delete the task using the TaskService
        // Return ResponseEntity.noContent()
        taskService.deleteTask(taskId);
        return ResponseEntity.noContent();
    }
}
