package com.example.backlog.task.port.in.usecase

import com.example.backlog.application.member.port.out.LoadMemberPort
import com.example.backlog.application.task.port.in.command.AssignManagerCommand
import com.example.backlog.application.task.port.in.usecase.AssignManagerUseCase
import com.example.backlog.application.task.port.in.usecase.impl.AssignManagerService
import com.example.backlog.application.task.port.out.LoadTaskPort
import com.example.backlog.application.task.port.out.UpdateTaskPort
import com.example.backlog.domain.member.entity.Member
import com.example.backlog.domain.task.entity.Task
import spock.lang.Shared
import spock.lang.Specification

class AssignManagerUseCaseSpec extends Specification{

    @Shared AssignManagerUseCase assignManagerUseCase
    LoadMemberPort loadMemberPort
    LoadTaskPort loadTaskPort
    UpdateTaskPort updateTaskPort;
    def "setup"(){
        loadMemberPort = Mock(LoadMemberPort)
        loadTaskPort = Mock(LoadTaskPort)
        updateTaskPort = Mock(UpdateTaskPort)
        assignManagerUseCase = new AssignManagerService(loadMemberPort,loadTaskPort,updateTaskPort)
    }

    def "should assing new manager to task"(){
        given:
            var cmd = new AssignManagerCommand(1L,1L)
        when:
            assignManagerUseCase.assignManager(cmd)
        then:
            1 * loadMemberPort.byId(_) >> Optional.of(new Member(1L,"Member"))
            1 * loadTaskPort.byId(_) >> Optional.of(new Task(1L,"title","desc",null,null))
            1 * updateTaskPort.updateTask(_) >> _
    }

}
