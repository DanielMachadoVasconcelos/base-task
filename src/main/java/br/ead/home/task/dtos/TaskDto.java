package br.ead.home.task.dtos;

import br.ead.home.task.entities.TaskCode;
import br.ead.home.task.entities.TaskStatus;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.UUID;

public record TaskDto(UUID id, TaskStatus taskStatus, TaskCode taskCode, String description, ZonedDateTime createdAt) implements Serializable {
}
