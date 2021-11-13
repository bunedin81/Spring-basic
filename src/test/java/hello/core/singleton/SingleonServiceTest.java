package hello.core.singleton;

import hello.core.beanfind.ApplicationContextExtendsFindTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class SingleonServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulServic1 = ac.getBean(StatefulService.class);
        StatefulService statefulServic2 = ac.getBean(StatefulService.class);

        //ThreadA : A사용자 10000원 주문
        statefulServic1.order("userA", 10000);
        //ThreadB : B사용자 20000원 주문
        statefulServic2.order("userB", 20000);

        //ThreadA : 사용자A 주문 금액 조회
//        int price = statefulServic1.getPrice();
//        System.out.println("price = " + price);

//        Assertions.assertThat(statefulServic1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}
