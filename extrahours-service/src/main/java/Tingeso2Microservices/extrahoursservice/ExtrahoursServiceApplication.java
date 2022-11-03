package Tingeso2Microservices.extrahoursservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ExtrahoursServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExtrahoursServiceApplication.class, args);
	}

}
