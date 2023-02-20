package sample.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;

import java.util.List;

@SpringBootTest
class SampleSpringBootRedisApplicationTests {

    @Autowired
    private StudentService studentService;
    @Autowired
    private CacheManager cacheManager;

    @Test
    void contextLoads() {
    }

    @Test
    public void findAll() {
        List<Student> list = studentService.findAll(this::getIp);
        for (Student student : list) {
            System.out.println(student.toString());
        }
    }

    private String getIp(String ip) {
        return "ip:" + ip;
    }

    @Test
    public void findById() {
        System.out.println(cacheManager.getClass());
        Student student = studentService.findById(41L);
        System.out.println(student.toString());
    }

    @Test
    public void update() {
        Student student = new Student();
        student.setId(1L);
        student.setAge(20);
        student.setName("张三");
        studentService.update(student);
    }

    @Test
    public void save() {
        Student student = new Student();
        student.setAge(99);
        student.setName("张三1");
        studentService.save(student);
    }

    @Test
    public void delete() {
        studentService.deleteById(4L);
    }
}
