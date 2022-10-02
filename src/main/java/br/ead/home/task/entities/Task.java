package br.ead.home.task.entities;

import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Task")
@Table(name = "task", schema = "taskservice", indexes = {
    @Index(name = "idx_task_status", columnList = "status"),
    @Index(name = "idx_task_code", columnList = "code")
})
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

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
}