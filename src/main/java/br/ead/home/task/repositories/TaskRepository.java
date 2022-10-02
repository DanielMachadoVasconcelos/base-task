package br.ead.home.task.repositories;

import br.ead.home.task.entities.Task;
import br.ead.home.task.entities.TaskStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface TaskRepository extends PagingAndSortingRepository<Task, UUID> {

    Page<Task> findByTaskStatus(TaskStatus taskStatus, Pageable pageable);

}