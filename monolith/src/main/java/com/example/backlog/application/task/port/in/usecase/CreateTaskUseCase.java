package com.example.backlog.application.task.port.in.usecase;

import com.example.backlog.application.task.port.in.command.CreateTaskCommand;

public interface CreateTaskUseCase {

  Long create(CreateTaskCommand command);
}
