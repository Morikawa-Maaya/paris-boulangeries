package com.example.pais_boulabgeries_app.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "bakery")

public class BakeryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "arrondissement", nullable = false)
    private Integer arrondissement;

    @Column(name = "address")
    private String address;

    @Column(name = "rating", nullable = false, precision = 2, scale = 1)
    private BigDecimal rating;

    @Column(name = "notes")
    private String notes;

    @Column(name = "visited_date", nullable = false)
    private LocalDate visited_date;

    @Column(name = "favorite")
    private Boolean favorite;

    @Column(name = "photo_url")
    private String photo_url;

    @Column(name = "maps_url")
    private String maps_url;

    public BakeryEntity() {
        // JPA用のデフォルトコンストラクタ
    }

    // --- Getter & Setter ---
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBakeryName() {
        return name;
    }

    public void setBakeryName(String name) {
        this.name = name;
    }

    public Integer getArrondissement() {
        return arrondissement;
    }

    public void setArrondissement(Integer arrondissement) {
        this.arrondissement = arrondissement;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDate getVisited_date() {
        return visited_date;
    }

    public void setVisited_date(LocalDate visited_date) {
        this.visited_date = visited_date;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public String getMaps_url() {
        return maps_url;
    }

    public void setMaps_url(String maps_url) {
        this.maps_url = maps_url;
    }
}