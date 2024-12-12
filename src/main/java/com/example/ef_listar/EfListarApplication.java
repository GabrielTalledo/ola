package com.example.ef_listar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EfListarApplication {

    public static void main(String[] args) {
        SpringApplication.run(EfListarApplication.class, args);
    }

}
