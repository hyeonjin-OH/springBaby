package inflearn.spring;

import inflearn.spring.aop.TimeTraceAop;
import inflearn.spring.repository.JdbcMemberRepository;
import inflearn.spring.repository.JpaMemberRepository;
import inflearn.spring.repository.MemberRepository;
import inflearn.spring.repository.MemoryMemberRepository;
import inflearn.spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    //private final DataSource dataSource;
    //private EntityManager em;
    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    /*
    public SpringConfig(EntityManager em) {
        //this.dataSource = dataSource;
        this.em = em;
    }*/

    @Autowired

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

    /*
    @Bean // or class에서 Component선언
    public TimeTraceAop timeTraceAop(){
        return new TimeTraceAop();
    }*/

    //@Bean
    //public MemberRepository memberRepository(){
        //return new JdbcMemberRepository(dataSource);
        //return new JdbcTemplateMemberRepository(dataSource);
        //return new JpaMemberRepository(em);

    //}
}
