package tapastop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tapastop.model.ConfirmationToken;
import tapastop.persistence.ConfirmationTokenPersistence;

import java.util.Optional;

public interface ConfirmationTokenDao extends JpaRepository<ConfirmationToken, Long> {
    Optional<ConfirmationToken> findByConfirmationToken(String confirmationToken);
}
