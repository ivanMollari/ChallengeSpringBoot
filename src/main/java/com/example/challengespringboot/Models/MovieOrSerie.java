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
            name = "movieOrSerie_cartoonCharacter",
            joinColumns = @JoinColumn(name = "movieOrSerie_id"),
            inverseJoinColumns = @JoinColumn(name = "cartoonCharacter_id")
    )
    private Set<CartoonCharacter> listCartoonCharacters;
    @ManyToMany(mappedBy = "listMoviesOrSeries")
    private Set<Gender> listGender;

    public MovieOrSerie() {
    }

    public MovieOrSerie(Long id, String title, String urlImg, LocalDate creationDate, Integer score, Set<CartoonCharacter> listCartoonCharacters) {
        this.id = id;
        this.title = title;
        this.urlImg = urlImg;
        this.creationDate = creationDate;
        this.score = score;
        this.listCartoonCharacters = listCartoonCharacters;
    }

    public MovieOrSerie(String title, String urlImg, LocalDate creationDate, Integer score, Set<CartoonCharacter> listCartoonCharacters) {
        this.title = title;
        this.urlImg = urlImg;
        this.creationDate = creationDate;
        this.score = score;
        this.listCartoonCharacters = listCartoonCharacters;
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

    public Set<CartoonCharacter> getListCharacters() {
        return listCartoonCharacters;
    }

    public void setListCharacters(Set<CartoonCharacter> listCartoonCharacters) {
        this.listCartoonCharacters = listCartoonCharacters;
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
                ", listCartoonCharacters=" + listCartoonCharacters +
                '}';
    }
}
