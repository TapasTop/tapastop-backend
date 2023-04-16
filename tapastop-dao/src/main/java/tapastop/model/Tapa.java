package tapastop.model;

import jakarta.persistence.*;
import org.hibernate.boot.model.source.spi.IdentifierSource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tapa", schema = "tapastop")
public class Tapa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @ManyToMany
    @JoinTable(name = "tapa_type",
            joinColumns = @JoinColumn(name = "tapa_id"),
            inverseJoinColumns = @JoinColumn(name = "type_id")
    )
    private List<Type> types;

    @ManyToMany
    @JoinTable(name = "tapa_region",
            joinColumns = @JoinColumn(name = "tapa_id"),
            inverseJoinColumns = @JoinColumn(name = "region_id")
    )
    private List<Region> regions;

    @Column(name = "picture")
    private String picture;

    @Column(name = "taste")
    private String taste;

    @OneToMany(mappedBy = "tapa")
    private List<Rating> ratings;

    @Temporal(TemporalType.TIMESTAMP)
    private Date addedDate;

    @Column(name = "description")
    private String description;


    public Tapa() {
    }

    public Tapa(String name, Restaurant restaurant, String picture, String taste, List<Type> types, List<Region> regions, String description) {
        this.name = name;
        this.restaurant = restaurant;
        this.types = types;
        this.picture = picture;
        this.taste = taste;
        this.regions = regions;
        this.addedDate = new Date(System.currentTimeMillis());
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
