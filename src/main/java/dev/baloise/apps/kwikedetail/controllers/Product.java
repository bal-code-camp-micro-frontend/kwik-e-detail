package dev.baloise.apps.kwikedetail.controllers;

import lombok.Data;

@Data
public class Product {
    private String id;
    private String name;
    private String type;
    private String imageUrl;
    private String price;
    private String recommendationFragment;

    private String getRecommendationPath() {
        return "/l/recommendations/"+this.id;
    }

    public String getRecommendationFragment() {
        String s = "<!--#include virtual=\""+getRecommendationPath()+"\" -->";
        return s;
    }
}


