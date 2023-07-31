package sample.consul;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Hand
    public void convert(Student student) {
        System.out.println(student.toString());
    }

}
