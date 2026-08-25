package com.example.pais_boulabgeries_app.bakery_list;

import com.example.pais_boulabgeries_app.entity.BakeryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BakeryRepository extends JpaRepository<BakeryEntity, Long> {
}
