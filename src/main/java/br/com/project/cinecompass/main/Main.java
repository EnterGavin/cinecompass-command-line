package br.com.project.cinecompass.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import br.com.project.cinecompass.model.DataEpisode;
import br.com.project.cinecompass.model.DataSeason;
import br.com.project.cinecompass.model.DataSeries;
import br.com.project.cinecompass.model.Episode;
import br.com.project.cinecompass.services.ConsumeAPI;
import br.com.project.cinecompass.services.ConvertData;

public class Main {
    private Scanner reading = new Scanner(System.in);

    private ConsumeAPI consume = new ConsumeAPI();

    private ConvertData convert = new ConvertData();

    private final String ADDRESS = "https://www.omdbapi.com/?t=";
    private final String APIKEY = "&apikey=74873d72";

    /**
     * 
     */
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
        
    //    for(int i = 0; i < data.totalSeason(); i++){
    //         List<DataEpisode> episodesSeason =  seasons.get(i).episodes();
    //         for(int j = 0; j < episodesSeason.size(); j++){
    //             System.out.println(episodesSeason.get(j).title());
    //         }
    //    }

      seasons.forEach(t -> t.episodes().forEach(e -> System.out.println(e.title())));

    //    List<String> names = Arrays.asList("Gavin", "Escarlet", "Eduarda","Cristina", "Junior");
    //    names.stream().filter(n -> n.startsWith("G")).sorted().limit(3).map(n -> n.toUpperCase()).forEach(System.out::println);
         

    List<DataEpisode> dataEpisodes = seasons.stream()
                        .flatMap(t -> t.episodes()
                        .stream())
                        .collect(Collectors.toList());
                      
            
                System.out.println("\nTop 5 Episodes: ");
                dataEpisodes.stream()
                        .filter(e -> !e.avaluation().equalsIgnoreCase("N/A"))
                        .sorted(Comparator.comparing(DataEpisode::avaluation).reversed())
                        .limit(5)
                        .forEach(System.out::println);

        
        List<Episode> epi = seasons.stream()
                            .flatMap(t -> t.episodes().stream()
                            .map(d -> new Episode(t.number(), d))
                            ).collect(Collectors.toList());

            epi.forEach(System.out::println);

    }
}
