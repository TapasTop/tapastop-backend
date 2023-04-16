package tapastop.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "region", schema = "tapastop")
public class Region {
    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "regions")
    private List<Tapa> tapas;


    public Region() {
    }

    public Region(String name) {
        this.name = name;
        this.tapas = new ArrayList<>();
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


    public List<Tapa> getTapas() {
        return tapas;
    }

    public void setTapas(List<Tapa> tapas) {
        this.tapas = tapas;
    }
}
