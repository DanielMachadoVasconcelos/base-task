package br.ead.home.task.repositories;

import br.ead.home.task.entities.TaskEntity;
import br.ead.home.task.entities.TaskStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface TaskRepository extends PagingAndSortingRepository<TaskEntity, String> {

    Page<TaskEntity> findByTaskStatus(TaskStatus taskStatus, Pageable pageable);

}