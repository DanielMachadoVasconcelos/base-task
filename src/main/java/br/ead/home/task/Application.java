package br.ead.home.task;

import br.ead.home.task.dtos.Restriction;
import br.ead.home.task.dtos.Task;
import br.ead.home.task.entities.RestrictionEntity;
import br.ead.home.task.entities.TaskCode;
import br.ead.home.task.entities.TaskEntity;
import br.ead.home.task.entities.TaskStatus;
import br.ead.home.task.mappers.TaskMapper;
import br.ead.home.task.repositories.TaskRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.ZonedDateTime;
import java.util.UUID;

@Log4j2
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner start(TaskMapper mapper, TaskRepository repository){
        return args -> {
            var taskId = UUID.randomUUID().toString();
            RestrictionEntity restriction = new RestrictionEntity(taskId, null, ZonedDateTime.now());
            TaskEntity task = new TaskEntity(taskId,
                    TaskStatus.DRAFT,
                    TaskCode.BOOKING_REQUEST,
                    "Description",
                    ZonedDateTime.now(),
                    restriction
            );
            TaskEntity persisted = repository.save(task);
            log.info("task_id=%s, status=%s, code=%s, restriction=%s".formatted(persisted.getId(), persisted.getTaskStatus(), persisted.getTaskCode(), persisted.getRestriction().getTaskId()));

            repository.findById(taskId).ifPresent(log::info);
        };
    }
}
