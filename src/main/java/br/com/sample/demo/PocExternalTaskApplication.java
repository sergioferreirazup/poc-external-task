package br.com.sample.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "br.com.sample.demo.integration")
public class PocExternalTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocExternalTaskApplication.class, args);
	}

}
