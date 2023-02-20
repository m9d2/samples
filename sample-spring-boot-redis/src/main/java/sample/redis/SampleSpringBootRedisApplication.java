package sample.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableCaching
@RestController
public class SampleSpringBootRedisApplication {

    @Autowired
    private StudentService studentService;

    public static void main(String[] args) {
        SpringApplication.run(SampleSpringBootRedisApplication.class, args);
    }

    @GetMapping()
    public Student findById(Long id) {
        return studentService.findById(id);
    }

}