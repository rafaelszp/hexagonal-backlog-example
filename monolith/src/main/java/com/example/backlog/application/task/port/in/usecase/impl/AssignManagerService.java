package com.example.backlog.application.task.port.in.usecase.impl;

import com.example.backlog.application.member.exception.MemberNotFoundException;
import com.example.backlog.application.task.exception.TaskNotFoundException;
import com.example.backlog.application.task.port.in.command.AssignManagerCommand;
import com.example.backlog.application.task.port.in.usecase.AssignManagerUseCase;
import com.example.backlog.application.member.port.out.LoadMemberPort;
import com.example.backlog.application.task.port.out.LoadTaskPort;
import com.example.backlog.application.task.port.out.UpdateTaskPort;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class AssignManagerService implements AssignManagerUseCase {

  private LoadMemberPort loadMemberPort;
  private LoadTaskPort loadTaskPort;
  private UpdateTaskPort updateTaskPort;


  @Inject
  public AssignManagerService(LoadMemberPort loadMemberPort, LoadTaskPort loadTaskPort, UpdateTaskPort updateTaskPort) {
    this.loadMemberPort = loadMemberPort;
    this.loadTaskPort = loadTaskPort;
    this.updateTaskPort = updateTaskPort;
  }

  @Override
  public void assignManager(AssignManagerCommand command) {
    var manager = loadMemberPort.byId(command.getManagerId()).orElseThrow(MemberNotFoundException::new);
    var task = loadTaskPort.byId(command.getTaskId()).orElseThrow(TaskNotFoundException::new);
    task.setManager(manager);
    updateTaskPort.updateTask(task);
  }
}
