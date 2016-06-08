package net.zuobin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Sahinn
 * @date 16/6/8
 */
@Configuration
@Import({BeanConfig.class})
public class InitConfig {
}
