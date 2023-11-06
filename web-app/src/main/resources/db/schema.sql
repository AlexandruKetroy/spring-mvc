CREATE TABLE t_tasks (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255),
    description VARCHAR(1000),
    priority VARCHAR(50),
    deadline TIMESTAMP,
    assignee VARCHAR(255)
);

CREATE TABLE t_users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255),
    task_priority VARCHAR(50)
);