package com.project.plantappui.model;

public class Plant {
    private String plantTitle;
    private String plantCountry;
    private String plantPrice;
    private int plantPicture;

    public Plant(String plantTitle, String plantCountry,String plantPrice, int plantPicture) {
        this.plantTitle = plantTitle;
        this.plantCountry = plantCountry;
        this.plantPrice = plantPrice;
        this.plantPicture = plantPicture;
    }

    public Plant() {}

    public String getPlantTitle() {
        return plantTitle;
    }

    public void setPlantTitle(String plantTitle) {
        this.plantTitle = plantTitle;
    }

    public String getPlantCountry() {
        return plantCountry;
    }

    public void setPlantCountry(String plantCountry) {
        this.plantCountry = plantCountry;
    }

    public String getPlantPrice() {
        return plantPrice;
    }

    public void setPlantPrice(String plantPrice) {
        this.plantPrice = plantPrice;
    }

    public int getPlantPicture() {
        return plantPicture;
    }

    public void setPlantPicture(int plantPicture) {
        this.plantPicture = plantPicture;
    }
}
