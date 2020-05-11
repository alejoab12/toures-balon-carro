package com.toures.balon.carro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient(autoRegister = false)
public class TouresBalonCarroApplication {

    public static void main(String[] args) {
        SpringApplication.run(TouresBalonCarroApplication.class, args);
    }

}
