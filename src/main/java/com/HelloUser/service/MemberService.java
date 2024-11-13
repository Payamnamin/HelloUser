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

    public void addMember(Member member) {
        members.add(member);
    }

    public void removeMember(String id) {
        members.removeIf(member -> member.getId().equals(id));
    }
}