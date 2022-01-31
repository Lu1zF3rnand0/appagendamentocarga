package br.edu.infnet.appagendamentocarga;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AppagendamentocargaApplication {
//
	public static void main(String[] args) {
		SpringApplication.run(AppagendamentocargaApplication.class, args);
	}

}
