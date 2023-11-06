package com.example.controller.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskRequest {

    private String title;

    private String description;

    private String priority;

    private LocalDateTime deadline;
}
