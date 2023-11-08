package com.example.repository;

import com.example.model.Priority;
import com.example.model.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findByTaskPriority(Priority priority);
}
