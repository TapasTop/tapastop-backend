package tapastop.model;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "restaurant", schema = "tapastop")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "description")
    private String description;

    @Column(name = "picture")
    private String picture;

    @Temporal(TemporalType.TIMESTAMP)
    private Date addedDate;

    public Restaurant() {
    }

    public Restaurant(String name, String address, String description, String picture) {
        this.name = name;
        this.address = address;
        this.description = description;
        this.picture = picture;
        this.addedDate = new Date(System.currentTimeMillis());
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
