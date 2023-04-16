package tapastop.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "type", schema = "tapastop")
public class Type {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "types")
    private List<Tapa> tapas;

    public Type() {
    }

    public Type(String name) {
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
}
