package com.example.repository;

import com.example.model.Priority;
import com.example.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private static final String SELECT_USER_SQL = "SELECT id, username, task_priority FROM t_users WHERE task_priority = :task_priority";
    private final NamedParameterJdbcTemplate jdbcTemplate;
    public Optional<User> findByTaskPriority(Priority priority) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("task_priority", priority.name());
        User user = jdbcTemplate.queryForObject(SELECT_USER_SQL, parameterSource, new BeanPropertyRowMapper<>(User.class));
        return Optional.ofNullable(user);
    }
}
