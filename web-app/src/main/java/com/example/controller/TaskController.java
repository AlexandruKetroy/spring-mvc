package com.example.controller;

import com.example.controller.dto.TaskRequest;
import com.example.controller.dto.TaskResponse;
import com.example.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
@Slf4j
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskResponse> addTask(@RequestBody TaskRequest taskRequest) {
        log.info("Received task:" + taskRequest);

        TaskResponse taskResponse = taskService.addTask(taskRequest);
        log.info("Sending response: " + taskResponse);
        return ResponseEntity.ok(taskResponse);
    }
}
