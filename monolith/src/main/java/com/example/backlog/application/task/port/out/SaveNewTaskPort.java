package com.example.backlog.application.task.port.out;

import com.example.backlog.domain.task.entity.Task;

public interface SaveNewTaskPort {
  Long saveNew(Task task);
}
