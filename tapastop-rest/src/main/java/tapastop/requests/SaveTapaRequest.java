package tapastop.requests;

import java.util.List;

public class SaveTapaRequest {

    private String name;
    private Long restaurant_id;
    private List<Long> type_id;
    private List<Long> region_id;
    private String picture;
    private String taste;
    private String description;

    public SaveTapaRequest(String name, Long restaurant_id, List<Long> type_id, List<Long> region_id, String picture, String taste, String description) {
        this.name = name;
        this.restaurant_id = restaurant_id;
        this.type_id = type_id;
        this.region_id = region_id;
        this.picture = picture;
        this.taste = taste;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
