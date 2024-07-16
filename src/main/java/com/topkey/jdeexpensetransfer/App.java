package com.topkey.jdeexpensetransfer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
@EnableDiscoveryClient
public class App {
	@Value("${test.test1.test2}")
    private String test2;
	
	@Value("${jde-table.F0911Z1.schema}")
    private String jdeSchema;
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	@PostConstruct
    public void showCustomConfiguration() {
        System.out.println("Custom test2: " + test2);
        System.out.println("jde-table.F0911Z1.schema: " + jdeSchema);
        
       
    }

}
