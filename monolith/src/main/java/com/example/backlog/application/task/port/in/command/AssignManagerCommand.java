package com.example.backlog.application.task.port.in.command;

import com.example.backlog.common.SelfValidating;
import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
public class AssignManagerCommand extends SelfValidating<AssignManagerCommand> {

  @NotNull
  private  Long managerId;
  @NotNull
  private Long taskId;

  public AssignManagerCommand(Long taskId, Long managerId) {
    this.managerId = managerId;
    this.taskId = taskId;
    this.validateSelf();
  }
}
