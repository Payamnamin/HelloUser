package com.HelloUser.service;

import com.HelloUser.model.Member;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private List<Member> members = new ArrayList<>();

    public List<Member> getAllMembers() {
        return members;
    }

    public void addMember(com.HelloUser.model.Member member) {
        members.add(member);
    }

    public void removeMember(String name) {
        members.removeIf(member -> member.getName().equals(name));
    }
}
