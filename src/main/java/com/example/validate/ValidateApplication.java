package com.example.validate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Administrator
 */
@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ValidateApplication {

    public static void main(String[] args) {
        SpringApplication.run(ValidateApplication.class, args);
    }

}
