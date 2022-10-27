package Tingeso2Microservices.clockservice;

import Tingeso2Microservices.clockservice.service.UploadTimestampsConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableConfigurationProperties({
		UploadTimestampsConfig.class
})
public class ClockServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClockServiceApplication.class, args);
	}

}
