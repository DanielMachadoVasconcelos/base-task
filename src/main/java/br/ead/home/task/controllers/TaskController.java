package br.ead.home.task.controllers;

import br.ead.home.task.dtos.TaskDto;
import br.ead.home.task.entities.TaskStatus;
import br.ead.home.task.mappers.TaskMapper;
import br.ead.home.task.repositories.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    private final TaskMapper taskMapper;
    private final TaskRepository taskRepository;

    @GetMapping("/{status}")
    public Page<TaskDto> findByStatus(@PathVariable("status") TaskStatus status) {
        return taskRepository.findByTaskStatus(status, Pageable.ofSize(10))
                .map(taskMapper::taskToTaskDto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskDto saveTask(@RequestBody @Validated TaskDto taskDto) {
        return taskMapper.taskToTaskDto(taskRepository.save(taskMapper.taskDtoToTask(taskDto)));
    }
}
