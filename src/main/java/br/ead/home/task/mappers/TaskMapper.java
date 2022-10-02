package br.ead.home.task.mappers;

import br.ead.home.task.entities.Task;
import br.ead.home.task.dtos.TaskDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TaskMapper {
    Task taskDtoToTask(TaskDto taskDto);

    TaskDto taskToTaskDto(Task task);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Task updateTaskFromTaskDto(TaskDto taskDto, @MappingTarget Task task);
}
