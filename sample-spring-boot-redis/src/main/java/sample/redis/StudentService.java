package sample.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
@CacheConfig(cacheNames = "student")
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public List<Student> findAll(Function<String, String> function) {
        System.out.println(function.andThen(function).apply("123"));
        System.out.println(function.apply("127.0.0.1"));
        return repository.findAll();
    }

    @Cacheable(key = "#id")
    public Student findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException(id + " is not found"));
    }

    @CachePut(key = "#student.id")
    public Student update(Student student) {
        return repository.saveAndFlush(student);
    }

    public Student save(Student student) {
        return repository.saveAndFlush(student);
    }

    @CacheEvict(key = "#id")
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
