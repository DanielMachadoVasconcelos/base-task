package br.ead.home.task.mappers;

import br.ead.home.task.dtos.Task;
import br.ead.home.task.entities.TaskEntity;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TaskMapper {

    TaskEntity toTaskEntity(Task task);

    Task toTask(TaskEntity taskEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    TaskEntity updateEntity(Task task, @MappingTarget TaskEntity taskEntity);

    @AfterMapping
    default void linkTask(@MappingTarget TaskEntity entity) {
        if (entity.getRestriction() != null) {
            entity.getRestriction().setTask(entity);
        }
    }
}
