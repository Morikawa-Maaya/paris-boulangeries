package com.example.pais_boulabgeries_app.bakery_list;

import com.example.pais_boulabgeries_app.dto.BakeryDto;
import com.example.pais_boulabgeries_app.entity.BakeryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class BakeryService {

    @Autowired
    private BakeryRepository bakeryRepository;

    public BakeryDto getBakeryById(Long id) {
        BakeryEntity entity = bakeryRepository.findById(id).get();
        BakeryDto bakery = new BakeryDto();
        copyEntityToBean(entity, bakery);
        return bakery;
    }

    public List<BakeryDto> getBakeryList() {
        List<BakeryDto> bakeries = new ArrayList<>();
        List<BakeryEntity> bakeryEntityList = bakeryRepository.findAll();
        bakeryEntityList.forEach(entity -> {
            BakeryDto bakery = new BakeryDto();
            copyEntityToBean(entity, bakery);
            bakeries.add(bakery);
        });
        return bakeries;
    }

    //Register
    public BakeryDto createBakery(BakeryDto bakery) {
        BakeryEntity entity = new BakeryEntity();
        copyBeanToEntityForInsert(bakery, entity);
        BakeryEntity createdEntity = bakeryRepository.save(entity);
        BakeryDto newBakery = new BakeryDto();
        copyEntityToBean(createdEntity, newBakery);
        return newBakery;
    }

    private void copyEntityToBean(BakeryEntity entity, BakeryDto bakery) {
        bakery.setId(entity.getId());
        bakery.setBakeryName(entity.getBakeryName());
        bakery.setArrondissement(entity.getArrondissement());
        bakery.setAddress(entity.getAddress());
        bakery.setRating(entity.getRating());
        bakery.setNotes(entity.getNotes());
        bakery.setVisitedDate(entity.getVisited_date());
        bakery.setFavorite(entity.getFavorite());
        bakery.setPhotoUrl(entity.getPhotoUrl());
        bakery.setMapsUrl(entity.getMapsUrl());

    }

    private void copyBeanToEntityForInsert(BakeryDto bakery, BakeryEntity entity) {
        entity.setBakeryName(bakery.getBakeryName());
        entity.setArrondissement(bakery.getArrondissement());

        //If not entered, it will be null.
        entity.setAddress(emptyToNull(bakery.getAddress()));

        entity.setRating(bakery.getRating());

        //If not entered, it will be null.
        entity.setNotes(emptyToNull(bakery.getNotes()));

        entity.setVisited_date(bakery.getVisitedDate());
        entity.setFavorite(bakery.getFavorite());

        //If not entered, it will be null.
        entity.setMapsUrl(emptyToNull(bakery.getMapsUrl()));

        //If a photo is uploaded
        if (bakery.getPhoto() != null && !bakery.getPhoto().isEmpty()) {

            String photoUrl = savePhoto(bakery.getPhoto());

            entity.setPhotoUrl(photoUrl);
        }
    }

    private String emptyToNull(String value) {
        if (value == null || value.isBlank()) {
            return null;
        }
        return value;
    }

    private String savePhoto(MultipartFile photo) {

        try {
            String originalFilename = photo.getOriginalFilename();

            String extension = "";

            if (originalFilename != null &&
                    originalFilename.contains(".")) {

                extension =
                        originalFilename.substring(
                                originalFilename.lastIndexOf(".")
                        );
            }

            String fileName =
                    UUID.randomUUID().toString() + extension;

            Path uploadPath =
                    Paths.get("uploads");

            Files.createDirectories(uploadPath);

            Path filePath =
                    uploadPath.resolve(fileName);

            Files.copy(
                    photo.getInputStream(),
                    filePath,
                    StandardCopyOption.REPLACE_EXISTING
            );

            return fileName;

        } catch (IOException e) {
            throw new RuntimeException("Échec de l'enregistrement de la photo", e);
        }
    }

}
