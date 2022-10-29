CREATE TABLE restriction
(
    task_id VARCHAR(255) NOT NULL,
    CONSTRAINT pk_restriction PRIMARY KEY (task_id)
);

CREATE TABLE task
(
    task_id    VARCHAR(255) NOT NULL,
    status     VARCHAR(255) NOT NULL,
    code       VARCHAR(255) NOT NULL,
    `description` LONGTEXT  NOT NULL,
    created_at datetime     NULL,
    CONSTRAINT pk_task PRIMARY KEY (task_id)
);

CREATE INDEX idx_task_code ON task (code);

CREATE INDEX idx_task_status ON task (status);

ALTER TABLE restriction
    ADD CONSTRAINT FK_RESTRICTION_ON_TASK FOREIGN KEY (task_id) REFERENCES task (task_id);