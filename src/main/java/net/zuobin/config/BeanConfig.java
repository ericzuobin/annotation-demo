package net.zuobin.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

/**
 * @author Sahinn
 * @date 16/6/8
 */
@Configuration
@ComponentScan(basePackages = "net.zuobin", excludeFilters = @ComponentScan.Filter(Controller.class))
public class BeanConfig {
}
