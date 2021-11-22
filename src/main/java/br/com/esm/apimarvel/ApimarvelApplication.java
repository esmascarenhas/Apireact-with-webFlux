package br.com.esm.apimarvel;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDynamoDBRepositories
public class ApimarvelApplication {

	public static void main(String[] args) {

		SpringApplication.run(ApimarvelApplication.class, args);
		System.out.println("super poderes com webflux");
	}

}
