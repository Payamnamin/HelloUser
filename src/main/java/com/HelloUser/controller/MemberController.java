package com.HelloUser.controller;

import com.HelloUser.model.Member;
import com.HelloUser.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@Controller
public class MemberController {
    
    @Autowired
    private MemberService memberService;

    @GetMapping("/")
    public String index() {
        return "login";
    }

    @PostMapping("/login")
    public String login(String username, String password, Model model) {
        
        boolean isAuthenticated = authenticate(username, password); 

        if (isAuthenticated) {
            return "redirect:/members";
        } else {
            model.addAttribute("error", true);
            return "login"; 
        }
    }

    
    private boolean authenticate(String username, String password) {
        return "user".equals(username) && "pass".equals(password);
    }

    @GetMapping("/members")
    public String members(Model model) {
        model.addAttribute("members", memberService.getAllMembers());
        return "members";
    }

    @GetMapping("/add-member")
    public String addMemberForm() {
        return "add-member";
    }

    @PostMapping("/add-member")
    public String addMember(String name) {
        String id = UUID.randomUUID().toString(); 
        memberService.addMember(new Member(id, name));
        return "redirect:/members";
    }

    @PostMapping("/remove-member/{id}")
public String removeMember(@PathVariable String id) {
    System.out.println("Removing member with ID: " + id);
    memberService.removeMember(id);
    return "redirect:/members";
}
}