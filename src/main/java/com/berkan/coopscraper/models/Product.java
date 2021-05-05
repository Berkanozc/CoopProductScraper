package com.berkan.coopscraper.models;

public class Product {
    private Long productCode;
    private String description;
    private String name;
    private String imageUrl;
    private String ingredients;

    public Product(Long productCode, String description, String name, String imageUrl, String ingredients) {
        this.productCode = productCode;
        this.description = description;
        this.name = name;
        this.imageUrl = imageUrl;
        this.ingredients = ingredients;
    }

    public Long getProductCode() {
        return productCode;
    }

    public void setProductCode(Long productCode) {
        this.productCode = productCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
}
