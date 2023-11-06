package com.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private Long id;

    private String username;

    private Priority taskPriority;
}
