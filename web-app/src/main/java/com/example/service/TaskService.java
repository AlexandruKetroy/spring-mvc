package com.example.service;

import com.example.controller.dto.TaskRequest;
import com.example.model.Priority;
import com.example.controller.dto.TaskResponse;
import com.example.model.Task;
import com.example.model.User;
import com.example.repository.TaskRepository;
import com.example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class TaskService {

    private final TaskRepository taskRepository;

    private final UserRepository userRepository;

    public TaskResponse addTask(TaskRequest taskRequest) {
        Task task = new Task();
        task.setTitle(taskRequest.getTitle());
        task.setDescription(taskRequest.getDescription());
        task.setPriority(Priority.fromValue(taskRequest.getPriority()));
        task.setDeadline(taskRequest.getDeadline());
        task.setAssignee(getAssignee(task.getPriority()));

        Task savedTask = taskRepository.save(task);
        log.info("Task with id " + savedTask.getId() + " was assigned to user " + savedTask.getAssignee());
        return new TaskResponse(savedTask.getId(), savedTask.getAssignee());
    }

    private String getAssignee(Priority priority) {
        User user = userRepository.findByTaskPriority(priority)
                .orElseThrow(() -> new IllegalArgumentException("User not found to assign to a task with priority:" + priority));
        return user.getUsername();
    }
}
