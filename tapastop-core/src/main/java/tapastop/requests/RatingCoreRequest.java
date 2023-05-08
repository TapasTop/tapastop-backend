package tapastop.requests;

import tapastop.model.Tapa;
import tapastop.model.User;

public class RatingCoreRequest {
    private String username;
    private Long tapaId;
    private Integer rate;
    private Tapa tapa;
    private User user;

    public RatingCoreRequest() {
    }

    public RatingCoreRequest(String username, Long tapaId, Integer rate) {
        this.username = username;
        this.tapaId = tapaId;
        this.rate = rate;
        this.tapa = null;
        this.user = null;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getTapaId() {
        return tapaId;
    }

    public void setTapaId(Long tapaId) {
        this.tapaId = tapaId;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Tapa getTapa() {
        return tapa;
    }

    public void setTapa(Tapa tapa) {
        this.tapa = tapa;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
