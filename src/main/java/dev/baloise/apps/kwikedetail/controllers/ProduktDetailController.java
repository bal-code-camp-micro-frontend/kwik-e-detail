package dev.baloise.apps.kwikedetail.controllers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/d")
public class ProduktDetailController {

    @RequestMapping("/product/{productId}")
    public String getProduktDetail(Model model, @PathVariable("productId") String productId) throws IOException {
        Optional<Product> product = getProductOptional(productId);
        if (!product.isPresent()) {
            throw new IllegalStateException("Not found");
        }
        model.addAttribute("productId", productId);
        model.addAttribute("product", product.get());
        return "product-detail";
    }

    private Optional<Product> getProductOptional(String productId) throws IOException {
        return readData().stream().filter(p -> productId.equals(p.getId())).findFirst();
    }

    private Product getProduct(String productId) throws IOException {
        for (Product p : readData()) {
            if (p.getId().equals(productId)) {
                return p;
            }
        }
        return null;
    }

    private List<Product> readData() throws IOException {
        Gson gson = new Gson();
        try (Reader reader = new InputStreamReader(getClass().getResourceAsStream("/data.json"))) {
            Type userListType = new TypeToken<ArrayList<Product>>() {
            }.getType();
            return gson.fromJson(reader, userListType);
        }
    }
}