package com.example.backlog.task.port.in.usecase

import com.example.backlog.application.task.port.in.command.CreateTaskCommand
import com.example.backlog.application.task.port.in.usecase.CreateTaskUseCase
import com.example.backlog.application.task.port.in.usecase.impl.CreateTaskService
import com.example.backlog.application.task.port.out.SaveNewTaskPort
import spock.lang.Shared
import spock.lang.Specification

import javax.validation.ConstraintViolationException

class CreateTaskUseCaseSpec extends Specification{

    @Shared SaveNewTaskPort saveNewTaskPort
    @Shared CreateTaskUseCase createTaskUseCase

    def setup(){
        saveNewTaskPort = Mock(SaveNewTaskPort)
        createTaskUseCase = new CreateTaskService(saveNewTaskPort)
    }

    def "should save new task"(){
        given:
            var cmd = new CreateTaskCommand("new task title","new task description")

        when:
            var result = createTaskUseCase.create(cmd)
        then:
            1 * saveNewTaskPort.saveNew(_) >> 1L
           result.equals(1L)
    }

    def "should throw exception because its invalid command"(){
        when:
            var cmd = new CreateTaskCommand("ti","dsc")
            createTaskUseCase.create(cmd)
        then:
            0 * saveNewTaskPort.saveNew(_)
            thrown(ConstraintViolationException)
    }

}
