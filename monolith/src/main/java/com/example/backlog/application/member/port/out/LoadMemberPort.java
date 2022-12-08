package com.example.backlog.application.member.port.out;

import com.example.backlog.domain.member.entity.Member;

import java.util.Optional;

public interface LoadMemberPort {
  Optional<Member> byId(Long managerId);
}
