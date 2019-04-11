package xyz.cavalheiro.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import xyz.cavalheiro.api.utils.PasswordUtils;

@SpringBootApplication
public class P14Application {

	public static void main(String[] args) {
		SpringApplication.run(P14Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			String passEncoded = PasswordUtils.generateBCrypt("123");
			System.out.println("Senha codificada: "+ passEncoded);
			
			passEncoded = PasswordUtils.generateBCrypt("123");
			System.out.println("A mesma senha codificada: "+ passEncoded);
			
			System.out.println("Senha válida: "+ PasswordUtils.validPass("123", passEncoded));

		};
	}
}
