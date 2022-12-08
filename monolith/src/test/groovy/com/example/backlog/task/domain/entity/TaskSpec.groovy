package com.example.backlog.task.domain.entity

import com.example.backlog.domain.member.entity.Member
import com.example.backlog.domain.task.entity.Task
import com.example.backlog.domain.task.vo.AssigneeList
import spock.lang.Specification

class TaskSpec extends Specification {

    def setup() {

    }

    def "should add members"() {
        given:
        var manager = new Member(0L,"manager");
        var m1 = new Member(1L,"member");

        var t = new Task(0L, "task", "description", manager)

        when:
        t.addMember(m1)

        then:
        t.getAssigneeList().getAssignees().size() > 0

    }

    def "should remove"() {

        given:
        var manager = new Member(0L,"manager");
        var m1 = new Member(1L,"teste");
        var asn = new AssigneeList(new HashSet<Member>());
        asn.add(m1)
        var t = new Task(0L, "task", "description", manager, asn)

        when:
            t.removeMember(m1);

        then:
            t.getAssigneeList().getAssignees().size() ==0
    }

}
