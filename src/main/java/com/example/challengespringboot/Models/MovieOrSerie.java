package com.example.challengespringboot.Models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class MovieOrSerie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String urlImg;
    private LocalDate creationDate;
    private Integer score;
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "movieOrSerie_character",
            joinColumns = {@JoinColumn(name = "movieOrSerie_id")},
            inverseJoinColumns = {@JoinColumn(name = "character_id")}
    )
    private Set<Character> listCharacters;
    @ManyToMany(mappedBy = "MovieOrSerie")
    private Set<Gender> listGender;

    public MovieOrSerie() {
    }

    public MovieOrSerie(Long id, String title, String urlImg, LocalDate creationDate, Integer score, Set<Character> listCharacters) {
        this.id = id;
        this.title = title;
        this.urlImg = urlImg;
        this.creationDate = creationDate;
        this.score = score;
        this.listCharacters = listCharacters;
    }

    public MovieOrSerie(String title, String urlImg, LocalDate creationDate, Integer score, Set<Character> listCharacters) {
        this.title = title;
        this.urlImg = urlImg;
        this.creationDate = creationDate;
        this.score = score;
        this.listCharacters = listCharacters;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Set<Character> getListCharacters() {
        return listCharacters;
    }

    public void setListCharacters(Set<Character> listCharacters) {
        this.listCharacters = listCharacters;
    }

    public Set<Gender> getListGender() {
        return listGender;
    }

    public void setListGender(Set<Gender> listGender) {
        this.listGender = listGender;
    }

    @Override
    public String toString() {
        return "MovieOrSerie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", urlImg='" + urlImg + '\'' +
                ", creationDate=" + creationDate +
                ", score=" + score +
                ", listCharacters=" + listCharacters +
                '}';
    }
}
