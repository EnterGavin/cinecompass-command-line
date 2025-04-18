package br.com.project.cinecompass.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.project.cinecompass.model.DataSeason;
import br.com.project.cinecompass.model.DataSeries;
import br.com.project.cinecompass.services.ConsumeAPI;
import br.com.project.cinecompass.services.ConvertData;

public class Main {
    private Scanner reading = new Scanner(System.in);

    private ConsumeAPI consume = new ConsumeAPI();

    private ConvertData convert = new ConvertData();

    private final String ADDRESS = "https://www.omdbapi.com/?t=";
    private final String APIKEY = "";

    public void showMenu(){
        System.out.println("Enter the name of the series: ");
        var nameSerie = reading.nextLine();
		var json = consume.obtainData(ADDRESS + nameSerie.replace(" ", "+") + APIKEY);
		DataSeries data = convert.getDados(json, DataSeries.class);
        System.out.println(data);


		List<DataSeason> seasons = new ArrayList<>();

		for (int i = 1; i <= data.totalSeason(); i++) {
			json = consume.obtainData(ADDRESS + nameSerie.replace(" ", "+") + "&season=" + i + APIKEY);
			DataSeason datasSeasons = convert.getDados(json, DataSeason.class);
			seasons.add(datasSeasons);
		}
		seasons.forEach(System.out::println);
        
       
         
    }
}
