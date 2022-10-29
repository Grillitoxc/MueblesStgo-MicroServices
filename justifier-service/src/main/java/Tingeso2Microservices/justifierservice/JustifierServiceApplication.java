package Tingeso2Microservices.justifierservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class JustifierServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(JustifierServiceApplication.class, args);
	}

}
