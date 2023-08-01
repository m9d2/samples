package sample.consul;

import lombok.Data;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Data
@RefreshScope
@RestController
@EnableFeignClients
@EnableDiscoveryClient
@Log4j2
public class SampleSpringBootConsulApplication {

    @Value("${sample}")
    private String sample;

    @Autowired
    private MyFeignClient feignClient;

    public static void main(String[] args) {
        SpringApplication.run(SampleSpringBootConsulApplication.class, args);
    }

    @GetMapping("local")
    public String local() {
        log.info("========== {} ===========", sample);
        return sample;
    }

    @GetMapping("remote")
    public String remote() {
        return feignClient.callRemote();
    }

}