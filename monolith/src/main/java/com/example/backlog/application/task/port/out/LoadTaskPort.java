package com.example.backlog.application.task.port.out;

import com.example.backlog.domain.task.entity.Task;

import java.util.Optional;

public interface LoadTaskPort {
  Optional<Task> byId(Long taskId);

}
