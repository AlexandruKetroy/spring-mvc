package com.example.repository;

import com.example.model.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Objects;

@Repository
@RequiredArgsConstructor
public class TaskRepository {

    private static final String INSERT_TASK_SQL = "INSERT INTO t_tasks (title, description, priority, deadline, assignee) VALUES " +
            "(:title, :description, :priority, :deadline, :assignee)";
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public Task save(Task task) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("title", task.getTitle());
        parameterSource.addValue("description", task.getDescription());
        parameterSource.addValue("priority", task.getPriority().name());
        parameterSource.addValue("deadline", Timestamp.valueOf(task.getDeadline()));
        parameterSource.addValue("assignee", task.getAssignee());

        final KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(INSERT_TASK_SQL, parameterSource, keyHolder);
        task.setId((getId(keyHolder)));

        return task;
    }

    private Long getId(final KeyHolder keyHolder) {
        final Number key = keyHolder.getKey();
        Objects.requireNonNull(key);
        return key.longValue();
    }
}
