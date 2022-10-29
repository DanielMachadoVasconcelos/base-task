package br.ead.home.task.entities;

import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "task")
@Table(name = "task", schema = "taskservice", indexes = {
    @Index(name = "idx_task_status", columnList = "status"),
    @Index(name = "idx_task_code", columnList = "code")
})
public class TaskEntity {

    @Id
    @Column(name = "task_id", nullable = false)
    private String id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private TaskStatus taskStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "code", nullable = false)
    private TaskCode taskCode;

    @Lob
    @Convert(converter = TaskDescriptionColumnConverter.class)
    @Column(name = "description", nullable = false)
    private String description;

    private ZonedDateTime createdAt;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "task", orphanRemoval = true)
    private RestrictionEntity restriction;

}