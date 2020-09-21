package dev.baloise.apps.kwikedetail.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProduktDetailController {

    @RequestMapping("/")
    public String getProduktDetail(Model model) {
        model.addAttribute("documentModel");
        return "product-detail";
    }
}