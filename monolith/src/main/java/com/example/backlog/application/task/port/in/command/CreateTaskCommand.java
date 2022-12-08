package com.example.backlog.application.task.port.in.command;

import com.example.backlog.common.SelfValidating;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Value
@EqualsAndHashCode
public class CreateTaskCommand extends SelfValidating<CreateTaskCommand> {

  @NotNull
  @Size(min=3,max = 80)
  private String title;
  @NotNull
  @Size(min = 10,max = 500)
  private String description;

  public CreateTaskCommand(String title, String description) {
    this.title = title;
    this.description = description;
    this.validateSelf();
  }
}
