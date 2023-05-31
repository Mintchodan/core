package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository()); // 멤버 서비스의 구현을 MemberServiceImpl 을 쓴다는걸 알 수 있음
    }

    @Bean
    public MemberRepository memberRepository() { // 멤버 리포지토리는 MemoryMemberRepository 를 쓴다는걸 알 수 있음
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() { // 오더 서비스의 리포지토리는 MemoryMemberRepository 를 쓰고
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
