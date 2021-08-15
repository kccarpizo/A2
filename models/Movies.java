
package com.example.restapiassign2.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author kimberlycarpizo
 */
@Document("movies")
public class Movies {
    
    @Id
    private String id;
    private String title;
    private String description;
    private String val;
    private String sm;
    private String lm;
    private String price;
    private String priceOut;
    private String featured;
    
    public Movies(){}

    public Movies(String id, String title, String description, String val, String sm, String lm, String price, String priceOut, String featured) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.val = val;
        this.sm = sm;
        this.lm = lm;
        this.price = price;
        this.priceOut = priceOut;
        this.featured = featured;
    }
    
    public String getId() {
        return id;
    }

    
    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public String getSm() {
        return sm;
    }

    public void setSm(String sm) {
        this.sm = sm;
    }

    public String getLm() {
        return lm;
    }

    public void setLm(String lm) {
        this.lm = lm;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPriceOut() {
        return priceOut;
    }

    public void setPriceOut(String priceOut) {
        this.priceOut = priceOut;
    }

    public String getFeatured() {
        return featured;
    }

    public void setFeatured(String featured) {
        this.featured = featured;
    }

    
    
    
    @Override
    public String toString() {
        return "Movies{" + "id=" + id + ", title=" + title + ", description=" + description + ", val=" + val + ", sm=" + sm + ", lm=" + lm + ", price=" + price + ", priceOut=" + priceOut + ", featured=" + featured + '}';
    }

    
}
