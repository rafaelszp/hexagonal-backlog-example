package com.example.backlog.application.task.port.in.usecase;

import com.example.backlog.application.task.port.in.command.AssignManagerCommand;

public interface AssignManagerUseCase {
  void assignManager(AssignManagerCommand command);
}
