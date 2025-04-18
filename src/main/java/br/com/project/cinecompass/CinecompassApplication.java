package br.com.project.cinecompass;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.project.cinecompass.main.Main;

@SpringBootApplication
public class CinecompassApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CinecompassApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Main main = new Main();
		main.showMenu();
		
		
	}

}
