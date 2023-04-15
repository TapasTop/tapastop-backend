package tapastop.model;

import jakarta.persistence.*;

@Entity
@Table(name = "rating", schema = "tapastop")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "tapa_id")
    private Tapa tapa;

    @Column(name = "rate")
    private Integer rate;

    public Rating() {
    }

    public Rating(User user, Tapa tapa, Integer rate) {
        this.user = user;
        this.tapa = tapa;
        this.rate = rate;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Tapa getTapa() {
        return tapa;
    }

    public void setTapa(Tapa tapa) {
        this.tapa = tapa;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
}
