package com.tfl.photoappapialbums;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PhotoAppApiAlbumsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhotoAppApiAlbumsApplication.class, args);
    }

}
