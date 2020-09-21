package dev.baloise.apps.kwikedetail.controllers;

import lombok.Data;

@Data
public class Product {
    private String id;
    private String name;
    private String type;
    private String imageUrl;
    private String price;
}
