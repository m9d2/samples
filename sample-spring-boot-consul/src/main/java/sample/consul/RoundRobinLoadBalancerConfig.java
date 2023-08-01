package sample.consul;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
import org.springframework.cloud.loadbalancer.core.RoundRobinLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class RoundRobinLoadBalancerConfig {
    @Bean
    ReactorLoadBalancer<ServiceInstance> roundRobinLoadBalancer(Environment environment, LoadBalancerClientFactory loadBalancerClientFactory) {
        String property = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
        return new RoundRobinLoadBalancer(loadBalancerClientFactory.getLazyProvider(property, ServiceInstanceListSupplier.class),property);
    }

}