package com.example.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Task {

    private Long id;

    private String title;

    private String description;

    private Priority priority;

    private LocalDateTime deadline;

    private String assignee;

}
