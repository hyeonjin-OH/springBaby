package inflearn.spring.controller;

import inflearn.spring.domain.Member;
import inflearn.spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new") //url설정
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")    //데이터 전달
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getNameT());

        memberService.join(member);
        System.out.println("name : " + form.getNameT());

        return "redirect:/";    //home화면으로 가는 것
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);

        return "members/memberlist";
    }
}
