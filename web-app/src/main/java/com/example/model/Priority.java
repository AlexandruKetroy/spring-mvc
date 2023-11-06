package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum Priority {
    LOW("low"),
    MEDIUM("medium"),
    HIGH("high");

    private final String value;

    public static Priority fromValue(String value) {
        return Arrays.stream(values())
                .filter(priority -> value.equals(priority.getValue()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Cannot retrieve the enum from value: " + value));
    }
}
