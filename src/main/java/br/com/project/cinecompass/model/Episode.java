package br.com.project.cinecompass.model;

import java.time.LocalDate;


public class Episode {

    public Episode(Integer numberSeason, DataEpisode dEpisode) {
        this.season = numberSeason;
        this.titleEpisode = dEpisode.title();
        this.numberEpisode = dEpisode.number();

        try {
            this.avaluation = Double.valueOf(dEpisode.avaluation());
        } catch (NumberFormatException ex) {
            this.avaluation = 0.0;
        }

        
        if (dEpisode.releaseDate() == null || dEpisode.releaseDate().equals("N/A") || dEpisode.releaseDate().isEmpty()) {
            this.releaseDateEpisode = null;
        } else {
            this.releaseDateEpisode = LocalDate.parse(dEpisode.releaseDate());
        }
        //TODO Auto-generated constructor stub
    }
    private Integer season;
    private String titleEpisode;
    private Integer numberEpisode; 
    private Double avaluation; 
    private LocalDate releaseDateEpisode;
    public Integer getSeason() {
        return season;
    }


    public void setSeason(Integer season) {
        this.season = season;
    }
    public String getTitleEpisode() {
        return titleEpisode;
    }
    public void setTitleEpisode(String titleEpisode) {
        this.titleEpisode = titleEpisode;
    }
    public Integer getNumberEpisode() {
        return numberEpisode;
    }
    public void setNumberEpisode(Integer numberEpisode) {
        this.numberEpisode = numberEpisode;
    }
    public Double getAvaluation() {
        return avaluation;
    }
    public void setAvaluation(Double avaluation) {
        this.avaluation = avaluation;
    }
    public LocalDate getReleaseDateEpisode() {
        return releaseDateEpisode;
    }
    public void setReleaseDateEpisode(LocalDate releaseDateEpisode) {
        this.releaseDateEpisode = releaseDateEpisode;
    }


    @Override
    public String toString() {
        return "[season=" + season + ", titleEpisode=" + titleEpisode + ", numberEpisode=" + numberEpisode
                + ", avaluation=" + avaluation + ", releaseDateEpisode=" + releaseDateEpisode;
    }

    
}
