package com.assignment.tasktracker.service;

import com.assignment.tasktracker.dto.TaskResponseDTO;
import com.assignment.tasktracker.model.Task;
import com.assignment.tasktracker.repository.TaskRepository;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public List<TaskResponseDTO> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        List<TaskResponseDTO> tasksResponse = new ArrayList<>();
        for(Task task: tasks) {
            TaskResponseDTO taskResponseDTO = mapEntityToDto(task);
            tasksResponse.add(taskResponseDTO);
        }
        return tasksResponse;
    }

    public Optional<TaskResponseDTO> getTaskById(Long taskId) {
        Optional<Task> task = taskRepository.findById(taskId);
        return task.map(this::mapEntityToDto);
    }

    public TaskResponseDTO createTask(Task task) {
        Task createdTask =  taskRepository.save(task);
        return mapEntityToDto(createdTask);
    }

    public TaskResponseDTO updateTask(Long taskId, Task updatedTask) {
        updatedTask.setId(taskId);
        Task createdTask =  taskRepository.save(updatedTask);
        return mapEntityToDto(createdTask);
    }

    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    private TaskResponseDTO mapEntityToDto(Task task) {

        return TaskResponseDTO.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .build();
    }
}
