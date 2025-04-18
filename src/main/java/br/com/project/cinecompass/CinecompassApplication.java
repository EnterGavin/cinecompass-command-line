package br.com.project.cinecompass;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.project.cinecompass.model.DataSeries;
import br.com.project.cinecompass.services.ConsumeAPI;
import br.com.project.cinecompass.services.ConvertData;

@SpringBootApplication
public class CinecompassApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CinecompassApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		ConsumeAPI consumeapi = new ConsumeAPI();
		var json = consumeapi.obtainData("https://www.omdbapi.com/?t=Breaking+Bad&apikey=74873d72");
		//System.out.println(json);
		//json = consumeapi.obtainData("https://coffee.alexflipnote.dev/random.json");
		System.out.println(json);
		ConvertData conversor = new ConvertData();
		DataSeries data = conversor.getDados(json, DataSeries.class);
		System.out.println(data);

	}

}
