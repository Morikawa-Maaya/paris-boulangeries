package com.example.pais_boulabgeries_app.bakery_list;

import com.example.pais_boulabgeries_app.entity.BakeryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BakeryService {

    @Autowired
    private BakeryRepository bakeryRepository;

    public Bakery getBakeryById(Long id) {
        BakeryEntity entity = bakeryRepository.findById(id).get();
        Bakery bakery = new Bakery();
        copyEntityToBean(entity, bakery);
        return bakery;
    }

    public List<Bakery> getBakeryList() {
        List<Bakery> bakeries = new ArrayList<>();
        List<BakeryEntity> bakeryEntityList = bakeryRepository.findAll();
        bakeryEntityList.forEach(entity -> {
            Bakery bakery = new Bakery();
            copyEntityToBean(entity, bakery);
            bakeries.add(bakery);
        });
        return bakeries;
    }

    //Register
    public Bakery createBakery(Bakery bakery) {
        BakeryEntity entity = new BakeryEntity();
        copyBeanToEntityForInsert(bakery, entity);
        BakeryEntity createdEntity = bakeryRepository.save(entity);
        Bakery newBakery = new Bakery();
        copyEntityToBean(createdEntity, newBakery);
        return newBakery;
    }

    private void copyEntityToBean(BakeryEntity entity, Bakery bakery) {
        bakery.setId(entity.getId());
        bakery.setBakeryName(entity.getBakeryName());
        bakery.setArrondissement(entity.getArrondissement());
        bakery.setAddress(entity.getAddress());
        bakery.setRating(entity.getRating());
        bakery.setNotes(entity.getNotes());
        bakery.setVisitedDate(entity.getVisited_date());
        bakery.setFavorite(entity.getFavorite());
        bakery.setPhotoUrl(entity.getPhoto_url());
        bakery.setMapsUrl(entity.getMaps_url());

    }

    private void copyBeanToEntityForInsert(Bakery bakery, BakeryEntity entity) {
        entity.setBakeryName(bakery.getBakeryName());
        entity.setArrondissement(bakery.getArrondissement());
        entity.setAddress(bakery.getAddress());
        entity.setRating(bakery.getRating());
        entity.setNotes(bakery.getNotes());
        entity.setVisited_date(bakery.getVisitedDate());
        entity.setFavorite(bakery.getFavorite());
        entity.setPhoto_url(bakery.getPhotoUrl());
        entity.setMaps_url(bakery.getMapsUrl());
    }
//    private void copyBeanToEntityForInsert(Bakery bakery, BakeryEntity entity) {
//        entity.setBakeryName("nameSample");
//        entity.setArrondissement(1);
//        entity.setAddress("1-1-1");
//        entity.setRating(new BigDecimal("4.5"));
//        entity.setNotes("trebien");
//        entity.setVisited_date(LocalDate.of(2020, 9, 8));
//        entity.setFavorite(Boolean.TRUE);
//        entity.setPhoto_url("....jpg");
//        entity.setMaps_url("....google.maps");
//    }
}
