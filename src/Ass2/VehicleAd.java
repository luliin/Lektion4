package Ass2;

/**
 * Created by Julia Wigenstedt
 * Date: 2020-09-22
 * Time: 15:05
 * Project: Lektion3
 * Copyright: MIT
 */
public abstract class VehicleAd implements IPublishable, IRevenuable{
    private int price;
    private String heading;
    private String description;
    private String color;
    private String brandModel;
    private int modelYear;
    private int distanceTravelled;



    public VehicleAd(String heading, String brandModel, int modelYear, String color, int distanceTravelled, int price, String description) {
        this.heading=heading;
        this.brandModel=brandModel;
        this.modelYear=modelYear;
        this.color=color;
        this.distanceTravelled=distanceTravelled;
        this.price=price;
        this.description=description;
    }

    public int getPrice() {
        return price;
    }

    public String getHeading() {
        return heading;
    }

    public String getDescription() {
        return description;
    }

    public String getColor() {
        return color;
    }

    public String getBrandModel() {
        return brandModel;
    }

    public int getModelYear() {
        return modelYear;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public abstract String getAdText();

    public abstract String getHeader();


}
