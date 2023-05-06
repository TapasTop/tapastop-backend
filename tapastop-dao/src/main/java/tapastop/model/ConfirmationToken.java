package tapastop.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
public class ConfirmationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="token_id")
    private Long tokenId;

    @Column(name="confirmation_token")
    private String confirmationToken;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @OneToOne(cascade = CascadeType.PERSIST)
    private User user;

    public ConfirmationToken() {
    }

    public ConfirmationToken(User user) {
        this.confirmationToken = UUID.randomUUID().toString();
        this.createdDate = new Date(System.currentTimeMillis());
        this.user = user;
    }

    public Long getTokenId() {
        return tokenId;
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
