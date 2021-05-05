package com.berkan.coopscraper.repositories;

import com.berkan.coopscraper.models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

    private WebDriver driver;
    private String BASE_URL = "https://www.coop.nl/product/";

    public ProductRepository() {
        setDriver(new HtmlUnitDriver());
    }

    public Product findByProductCode(String productCode) {
        // Open website
        getDriver().get(BASE_URL + productCode);

        try {
            // Fetch all needed information
            String imageUrl = getDriver().findElement(By.cssSelector(".product-image > div > img")).getAttribute("src");
            String name = getDriver().findElement(By.cssSelector(".pdp__title > span")).getText();
            String description = getDriver().findElement(By.cssSelector(".pdp__cms-content")).getText();
            String ingredients = getDriver().findElement(By.cssSelector(".pdp__content > p")).getText();

            // Create product object
            return new Product(Long.parseLong(productCode), description, name, imageUrl, ingredients);
        } catch (NotFoundException exception) {
            // When no product information are found return null
            return null;
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
