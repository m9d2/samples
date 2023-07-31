package sample.consul;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SampleSpringBootElasticApplicationTests {

    @Autowired
    private StudentService service;

    @Test
    public void test() {
        service.convert(Student.builder().name("高阳").build());
    }
}
