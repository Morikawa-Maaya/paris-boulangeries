package com.example.pais_boulabgeries_app.bakery_list;

import com.example.pais_boulabgeries_app.dto.BakeryDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BakeryPageController {

    @Autowired
    private final BakeryService bakeryService;

    public BakeryPageController(BakeryService bakeryService) {
        this.bakeryService = bakeryService;
    }

    //Home
    @GetMapping("/")
    public String showHome(Model model) {

        // Show bakery list from DB
        model.addAttribute("bakeries", bakeryService.getBakeryList());

        return "index";
    }

    // get information of user tipped text
    @GetMapping("/bakery/registration")
    public String showRegistration(Model model) {

        model.addAttribute("bakeryDto", new BakeryDto());

        return "registration";
    }

    // keep information of user tipped text when user returned to modify page
    @PostMapping("/bakery/registration")
    public String registrationFromConfirmation(
            @ModelAttribute("bakeryDto") BakeryDto bakeryDto) {

        return "registration";
}

    // show detail information of one bakery
    @GetMapping("/bakery/{id}")
    public String showDetail(
            @PathVariable Long id,
            Model model) {

        BakeryDto bakery = bakeryService.getBakeryById(id);

        model.addAttribute("bakery", bakery);

        return "detail";
    }

    @PostMapping("/bakery/confirm")
    public String confirmBakery(
            @Valid @ModelAttribute("bakeryDto") BakeryDto bakeryDto,
            BindingResult bindingResult,
            Model model) {

        // If there is a validation error
        if (bindingResult.hasErrors()) {
            return "registration";
        }

        // Go to the confirmation page if no errors are found
        return "confirmation";
    }

    // show edit page
    @GetMapping("/bakery/{id}/edit")
    public String showEdit(
            @PathVariable Long id,
            Model model) {

        BakeryDto bakery = bakeryService.getBakeryById(id);

        model.addAttribute("bakery", bakery);

        return "edit";
    }
}
