package br.com.project.cinecompass.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public record  DataEpisode
                (
                    @JsonAlias("Title") String title,
                    @JsonAlias("Episode") Integer number, 
                    @JsonAlias("imdbRating") String avaluation, 
                    @JsonAlias("released") String releaseDate
                    ) {

}
