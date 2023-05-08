package tapastop.reponses;

public class RatingResponse {

    private Long rating_id;
    private String user_username;
    private Long tapa_id;
    private String tapa_name;
    private Integer rate;

    public RatingResponse() {
    }

    public RatingResponse(Long rating_id, String user_username, Long tapa_id, String tapa_name, Integer rate) {
        this.rating_id = rating_id;
        this.user_username = user_username;
        this.tapa_id = tapa_id;
        this.tapa_name = tapa_name;
        this.rate = rate;
    }

    public Long getRating_id() {
        return rating_id;
    }

    public void setRating_id(Long rating_id) {
        this.rating_id = rating_id;
    }

    public String getUser_username() {
        return user_username;
    }

    public void setUser_username(String user_username) {
        this.user_username = user_username;
    }

    public Long getTapa_id() {
        return tapa_id;
    }

    public void setTapa_id(Long tapa_id) {
        this.tapa_id = tapa_id;
    }

    public String getTapa_name() {
        return tapa_name;
    }

    public void setTapa_name(String tapa_name) {
        this.tapa_name = tapa_name;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
}
