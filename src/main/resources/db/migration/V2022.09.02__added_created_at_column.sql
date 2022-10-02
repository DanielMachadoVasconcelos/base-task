use taskservice;

ALTER TABLE taskservice.task
    ADD created_at datetime NULL DEFAULT CURRENT_TIMESTAMP ;

