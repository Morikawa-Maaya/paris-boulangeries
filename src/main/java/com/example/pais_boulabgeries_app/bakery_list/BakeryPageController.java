package com.example.pais_boulabgeries_app.bakery_list;

import com.example.pais_boulabgeries_app.dto.BakeryDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BakeryPageController {
    @GetMapping("/registration")
    public String showRegistration(Model model) {

        model.addAttribute("bakeryDto", new BakeryDto());

        return "registration";
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


}
