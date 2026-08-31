package com.example.pais_boulabgeries_app.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class BakeryDto {

    private Long id;

    @NotBlank(message = "Le nom est obligatoire.")
    private String bakeryName;

    @NotNull(message = "L'arrondissement est obligatoire.")
    private Integer arrondissement;

    private String address;

    @NotNull(message = "L'évaluation est obligatoire.")
    private BigDecimal rating;

    private String notes;

    private Boolean favorite;

    @NotNull(message = "La date de visite est obligatoire.")
    private LocalDate visitedDate;

    // upload photo
    private MultipartFile photo;

    // photo URL
    private String photoUrl;

    private String mapsUrl;

}
