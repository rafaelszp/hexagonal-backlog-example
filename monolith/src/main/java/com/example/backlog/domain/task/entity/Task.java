package com.example.backlog.domain.task.entity;

import com.example.backlog.domain.member.entity.Member;
import com.example.backlog.domain.task.vo.AssigneeList;
import lombok.*;
import lombok.experimental.NonFinal;

import java.util.HashSet;
import java.util.Objects;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {

  private Long id;
  private String title;
  private String description;
  private Member manager;
  @NonFinal
  @Getter
  private AssigneeList assigneeList;

  public Task(String title, String description) {
    this.title = title;
    this.description = description;
  }

  public Task(Long id, String title, String description, Member manager) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.manager = manager;
  }

  public void addMember(Member member){
    if(!canAssign()){
        this.assigneeList = new AssigneeList(new HashSet<>());
    }
    this.assigneeList.add(member);
  }

  public void removeMember(Member member){
    if (canAssign()){
      this.assigneeList.removeMember(member);
    }
  }

  protected boolean canAssign(){
    return Objects.nonNull(this.assigneeList);
  }

}
