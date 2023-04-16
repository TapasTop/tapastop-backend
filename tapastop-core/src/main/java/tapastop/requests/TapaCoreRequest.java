package tapastop.requests;

import tapastop.model.Region;
import tapastop.model.Restaurant;
import tapastop.model.Type;

import java.util.List;

public class TapaCoreRequest {
    private String name;
    private Long restaurant_id;
    private List<Long> type_id;
    private List<Long> region_id;
    private String picture;
    private String taste;
    private List<Region> region;
    private List<Type> type;
    private Restaurant restaurant;
    private String description;

    public TapaCoreRequest(String name, Long restaurant_id, List<Long> type_id, List<Long> region_id, String picture, String taste, String description) {
        this.name = name;
        this.restaurant_id = restaurant_id;
        this.type_id = type_id;
        this.region_id = region_id;
        this.picture = picture;
        this.taste = taste;
        this.type = null;
        this.restaurant = null;
        this.region = null;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(Long restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public List<Long> getType_id() {
        return type_id;
    }

    public void setType_id(List<Long> type_id) {
        this.type_id = type_id;
    }

    public List<Long> getRegion_id() {
        return region_id;
    }

    public void setRegion_id(List<Long> region_id) {
        this.region_id = region_id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public List<Region> getRegion() {
        return region;
    }

    public List<Type> getType() {
        return type;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRegion(List<Region> region) {
        this.region = region;
    }

    public void setType(List<Type> type) {
        this.type = type;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
