use taskservice;

CREATE TABLE taskservice.task
(
    id     binary(255)      NOT NULL,
    status VARCHAR(255) NOT NULL,
    code   VARCHAR(255) NOT NULL,
    `description` LONGTEXT NOT NULL,
    CONSTRAINT pk_task PRIMARY KEY (id)
);

CREATE INDEX idx_task_code ON taskservice.task (code);

CREATE INDEX idx_task_status ON taskservice.task (status);