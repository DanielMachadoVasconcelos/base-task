package br.ead.home.task.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "restriction")
public class RestrictionEntity {

    @Id
    private String taskId;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn(name="task_id", referencedColumnName="task_id", columnDefinition = "task_id")
    private TaskEntity task;

    private ZonedDateTime createdAt;
}