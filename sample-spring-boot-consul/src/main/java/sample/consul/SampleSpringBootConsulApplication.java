package sample.consul;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Data
@RefreshScope
@RestController
public class SampleSpringBootConsulApplication {

    @Value("${sample}")
    private String sample;

    public static void main(String[] args) {
        SpringApplication.run(SampleSpringBootConsulApplication.class, args);
    }

    @GetMapping
    public String test() {
        return sample;
    }
}