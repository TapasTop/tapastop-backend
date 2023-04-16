package tapastop.reponses;

import java.util.List;

public class TapaResponse {

    private Long id;
    private String name;
    private String restaurant_name;
    private Long restaurant_id;
    private List<String> types_names;
    private List<String> region_names;
    private String picture;
    private String taste;

    public TapaResponse(Long id, String name, String restaurant_name, Long restaurant_id, List<String> types_names, List<String> region_names, String picture, String taste) {
        this.id = id;
        this.name = name;
        this.restaurant_name = restaurant_name;
        this.restaurant_id = restaurant_id;
        this.types_names = types_names;
        this.region_names = region_names;
        this.picture = picture;
        this.taste = taste;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRestaurant_name() {
        return restaurant_name;
    }

    public void setRestaurant_name(String restaurant_name) {
        this.restaurant_name = restaurant_name;
    }

    public Long getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(Long restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public List<String> getTypes_names() {
        return types_names;
    }

    public void setTypes_names(List<String> types_names) {
        this.types_names = types_names;
    }

    public List<String> getRegion_names() {
        return region_names;
    }

    public void setRegion_names(List<String> region_names) {
        this.region_names = region_names;
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
}
