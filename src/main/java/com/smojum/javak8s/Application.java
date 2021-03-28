package com.smojum.javak8s;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(proxyBeanMethods = false)
public class Application {
    public static void main(String[] args) {
//		System.setProperty("spring.main.cloud-platform", "kubernetes");
//		System.setProperty("EXECUTION_ENVIRONMENT", "cloud9");
        SpringApplication.run(Application.class, args);
    }
}


