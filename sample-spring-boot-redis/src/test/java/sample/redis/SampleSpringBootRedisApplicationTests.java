package sample.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SampleSpringBootRedisApplicationTests {

    @Autowired
    private StudentService studentService;

    @Test
    void contextLoads() {
    }

    @Test
    public void findAll() {
        List<Student> list = studentService.findAll();
        for (Student student : list) {
            System.out.println(student.toString());
        }
    }

    @Test
    public void findById() {
        Student student = studentService.findById(1L);
        System.out.println(student.toString());
    }
}
