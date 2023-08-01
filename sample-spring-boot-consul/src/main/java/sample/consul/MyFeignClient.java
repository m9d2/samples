package sample.consul;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "sample-consul-service")
@LoadBalancerClient(name = "sample-consul-service", configuration = RoundRobinLoadBalancerConfig.class)
public interface MyFeignClient {

    @GetMapping("/sample-consul/local")
    String callRemote();
}
