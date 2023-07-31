package sample.sharding.jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void save() {
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setId((long) i);
            user.setName("test" + i);
            userService.save(user);
        }
    }

    @Test
    void deleteById() {
    }
}