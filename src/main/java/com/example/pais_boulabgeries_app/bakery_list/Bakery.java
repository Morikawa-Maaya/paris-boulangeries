package com.example.pais_boulabgeries_app.bakery_list;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.validation.constraints.NotBlank;

@Getter
@Setter
public class Bakery {

    @NotBlank
    private Long id;

    private String bakeryName;

    private Integer arrondissement;

    private String address;

    private BigDecimal rating;

    private String notes;

    private Boolean favorite;

    private LocalDate visitedDate;

    private String photoUrl;

    private String mapsUrl;

}
