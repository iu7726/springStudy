package hello.myspring;

import hello.myspring.aop.TimeTraceAop;
import hello.myspring.repository.JdbcMemberRepository;
import hello.myspring.repository.JdbcTemplateMemberRepository;
import hello.myspring.repository.JpaMemberRepository;
import hello.myspring.repository.MemberRepository;
import hello.myspring.service.MemberService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

}
