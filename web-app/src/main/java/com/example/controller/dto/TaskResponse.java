package com.example.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskResponse {

    private Long taskId;

    private String assignee;
}
