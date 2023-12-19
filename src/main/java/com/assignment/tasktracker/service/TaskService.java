package com.assignment.tasktracker.service;

import com.assignment.tasktracker.dto.TaskRequestDTO;
import com.assignment.tasktracker.dto.TaskResponseDTO;
import com.assignment.tasktracker.model.Task;
import com.assignment.tasktracker.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TaskService {

    /*
    This class has all the business logic
     */

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
        /*
        If task contains a value the mapEntityToDto method is applied to
        the value inside the Optional, and the result is wrapped in a new Optional.
        So, you end up with an Optional<TaskResponseDTO>.

        If task is empty, the map operation is skipped, and you get an empty
        Optional<TaskResponseDTO>
         */
        return task.map(this::mapEntityToDto);
    }

    /*
    Converting the Request DTO Object to the Entity Task
    to save to the database
     */
    public TaskResponseDTO createTask(TaskRequestDTO task) {
        Task createdTask =  taskRepository.save(mapDtoToEntity(task));
        return mapEntityToDto(createdTask);
    }
    
    /*
    Converting the TaskRequestDTO to Task Entity
    Setting the id in the task entity and updating task in the database
     */

    public TaskResponseDTO updateTask(Long taskId, TaskRequestDTO updatedTaskRequest) {
        Task updatedTask = mapDtoToEntity(updatedTaskRequest);
        updatedTask.setId(taskId);
        Task createdTask =  taskRepository.save(updatedTask);
        return mapEntityToDto(createdTask);
    }

    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    /*
    This utility method is to map the Task entity to
    the data transfer object TaskResponseDTO
    In order to hide the underlying contents of the entity
    we are not returning the entity object but
    rather another response object which may or may not have
    all the properties of the entity
     */
    private TaskResponseDTO mapEntityToDto(Task task) {

        return TaskResponseDTO.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .build();
    }
    
    private Task mapDtoToEntity(TaskRequestDTO taskRequestDTO) {
        return Task.builder()
                .title(taskRequestDTO.getTitle())
                .description(taskRequestDTO.getDescription())
                .build();
    }
}
