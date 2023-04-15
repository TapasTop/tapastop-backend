package tapastop.model;

import jakarta.persistence.*;
import tapastop.utils.Taste;

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

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    @Column(name = "picture")
    private String picture;

    @Column(name = "taste")
    private Taste taste;

    @OneToMany(mappedBy = "tapa")
    private List<Rating> ratings;


    public Tapa() {
    }

    public Tapa(String name, Restaurant restaurant, Type type, Region region, String picture, Taste taste) {
        this.name = name;
        this.restaurant = restaurant;
        this.type = type;
        this.region = region;
        this.picture = picture;
        this.taste = taste;
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
