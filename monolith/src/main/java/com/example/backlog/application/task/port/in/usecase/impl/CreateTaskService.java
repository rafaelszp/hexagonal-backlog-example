package com.example.backlog.application.task.port.in.usecase.impl;

import com.example.backlog.application.task.port.in.command.CreateTaskCommand;
import com.example.backlog.application.task.port.in.usecase.CreateTaskUseCase;
import com.example.backlog.application.task.port.out.SaveNewTaskPort;
import com.example.backlog.domain.task.entity.Task;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CreateTaskService implements CreateTaskUseCase {

  private SaveNewTaskPort saveNewTaskPort;

  @Inject
  public CreateTaskService(SaveNewTaskPort saveNewTaskPort) {
    this.saveNewTaskPort = saveNewTaskPort;
  }

  @Override
  public Long create(CreateTaskCommand command) {
   var task = new Task(command.getTitle(),command.getDescription());
   Long savedId = saveNewTaskPort.saveNew(task);
    return savedId;
  }
}
