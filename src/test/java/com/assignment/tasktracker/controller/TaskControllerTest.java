package com.assignment.tasktracker.controller;

import com.assignment.tasktracker.dto.TaskRequestDTO;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.assignment.tasktracker.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TaskService taskService;

    @Test
    void getAllTasks() throws Exception {
        TaskRequestDTO task1 = new TaskRequestDTO("Task 1", "Description 1");
        TaskRequestDTO task2 = new TaskRequestDTO("Task 2", "Description 2");
        taskService.createTask(task1);
        taskService.createTask(task2);

        mockMvc.perform(MockMvcRequestBuilders.get("/tasks"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].title").value("Task 1"))
                .andExpect(jsonPath("$[0].description").value("Description 1"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].title").value("Task 2"))
                .andExpect(jsonPath("$[1].description").value("Description 2"));
    }

    @Test
    void createTask() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/tasks")
                        .content("{\"title\":\"New Task\",\"description\":\"New Description\"}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.title").value("New Task"))
                .andExpect(jsonPath("$.description").value("New Description"));
    }
}
