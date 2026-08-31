package com.example.pais_boulabgeries_app.bakery_list;

import com.example.pais_boulabgeries_app.dto.BakeryDto;
import com.example.pais_boulabgeries_app.dto.HttpResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BakeryController {
    @Autowired
    private BakeryService bakeryService;

    @GetMapping(path = "/api/bakery/{id}")
    public HttpResponseDto getBakeryById(@PathVariable("id") Long id) {
        HttpResponseDto httpResponseDto = new HttpResponseDto();
        BakeryDto bakery = bakeryService.getBakeryById(id);
        httpResponseDto.setHttpStatus(HttpStatus.OK);
        httpResponseDto.setResponseData(bakery);
        return httpResponseDto;
    }

    @GetMapping(path = "/api/bakery")
    public HttpResponseDto getBakeryList() {
        HttpResponseDto httpResponseDto = new HttpResponseDto();
        List<BakeryDto> bakery = bakeryService.getBakeryList();
        httpResponseDto.setHttpStatus(HttpStatus.OK);
        httpResponseDto.setResponseData(bakery);
        return httpResponseDto;
    }

//    @PostMapping(path = "/api/bakery")
//    public HttpResponseDto createBakery(@ModelAttribute  BakeryDto bakery) {
//        HttpResponseDto httpResponseDto = new HttpResponseDto();
//        BakeryDto newBakery = bakeryService.createBakery(bakery);
//        httpResponseDto.setHttpStatus(HttpStatus.CREATED);
//        httpResponseDto.setResponseData(newBakery);
//        return httpResponseDto;
//    }

    @PostMapping(path = "/api/bakery")
    public HttpResponseDto createBakery(@ModelAttribute BakeryDto bakery) {

        System.out.println("===== POST /api/bakery =====");
        System.out.println("bakeryName: " + bakery.getBakeryName());
        System.out.println("arrondissement: " + bakery.getArrondissement());
        System.out.println("address: " + bakery.getAddress());
        System.out.println("rating: " + bakery.getRating());
        System.out.println("notes: " + bakery.getNotes());
        System.out.println("favorite: " + bakery.getFavorite());
        System.out.println("visitedDate: " + bakery.getVisitedDate());
        System.out.println("photo: " + bakery.getPhoto());
        System.out.println("mapsUrl: " + bakery.getMapsUrl());

        HttpResponseDto httpResponseDto = new HttpResponseDto();

        BakeryDto newBakery = bakeryService.createBakery(bakery);

        httpResponseDto.setHttpStatus(HttpStatus.CREATED);
        httpResponseDto.setResponseData(newBakery);

        return httpResponseDto;
    }


//    @PutMapping(path = "/api/bakery/{id}")
//    public HttpResponseDto updateBakery(@PathVariable("id") Long id, @RequestBody Bakery bakery) {
//        HttpResponseDto httpResponseDto = new HttpResponseDto();
//        bakery.setId(id);
//        Bakery updatedBakery = bakeryService.updateBakery(bakery);
//        httpResponseDto.setHttpStatus(HttpStatus.CREATED);
//        httpResponseDto.setResponseData(updatedBakery);
//        return httpResponseDto;
//    }

//    @DeleteMapping(path = "/api/bakery/{id}")
//    public HttpResponseDto deleteBakery(@PathVariable("id") Long id) {
//        HttpResponseDto httpResponseDto = new HttpResponseDto();
//        if (bakeryService.deleteEmployeeById(employeeId)) {
//            httpResponseDto.setHttpStatus(HttpStatus.OK);
//            httpResponseDto.setMessage("delete success.");
//        } else {
//            // do something
//        }
//        return httpResponseDto;
//    }
}
