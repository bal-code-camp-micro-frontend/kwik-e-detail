package dev.baloise.apps.kwikedetail.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProduktDetailController {

    @RequestMapping("/{productId}")
    public String getProduktDetail(Model model, @PathVariable("productId") String productId) {
        model.addAttribute("productId", productId);
        return "product-detail";
    }
}