package br.com.project.cinecompass.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public record DataSeries
                    (
                    @JsonAlias("Title") String title,
                    @JsonAlias("totalSeasons") Integer totalSeason,
                    @JsonAlias("imdbRating") String Avaluation                  
                    ) {


}
