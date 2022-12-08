package com.example.backlog.domain.task.vo;

import com.example.backlog.domain.member.entity.Member;
import lombok.Value;

import java.util.Set;
import java.util.stream.Collectors;

@Value
public class AssigneeList {
  private Set<Member> assignees;

  public void add(Member member) {
    this.assignees.add(member);
  }

  public void removeMember(Member member) {
    this.assignees.remove(member);
  }
}
