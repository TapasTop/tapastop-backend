package tapastop.requests;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import tapastop.model.Tapa;
import tapastop.model.User;

public class SaveRatingRequest {

    private String username;
    private Long tapa_id;
    private Integer rate;

    public SaveRatingRequest() {
    }

    public SaveRatingRequest(String username, Long tapa_id, Integer rate) {
        this.username = username;
        this.tapa_id = tapa_id;
        this.rate = rate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getTapaId() {
        return tapa_id;
    }

    public void setTapaId(Long tapaId) {
        this.tapa_id = tapaId;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
}
