package com.HelloUser.controller;

import com.HelloUser.model.Member;
import com.HelloUser.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class MemberController {
    
    @Autowired
    private MemberService memberService;

    @GetMapping("/")
    public String index() {
        return "index";

    }
    @GetMapping("/members")
    public String members(Model model) {
        model.addAttribute("members" , memberService.getAllMembers());
        return "members";
    }

    @GetMapping("/add-member")
    public String addMemberForm(){
        return "add-member";
    }

    @PostMapping("/add-member")
    public String addMember(String name) {
        memberService.addMember(new Member(name));
        return "redirect:/members";
    }
   
    @PostMapping("/remove-member")
    public String removeMember(String name) {
        memberService.removeMember(name);
        return"redirect/members";
    }
}
