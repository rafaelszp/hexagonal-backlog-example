package com.example.backlog.application.task.port.out;

import com.example.backlog.domain.task.entity.Task;

public interface UpdateTaskPort {
  void updateTask(Task task);
}
