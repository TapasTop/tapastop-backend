package tapastop.persistence;

import tapastop.model.ConfirmationToken;

import java.util.Optional;

public interface ConfirmationTokenPersistence {
    public ConfirmationToken save(ConfirmationToken confirmationToken);
    public Optional<ConfirmationToken> findByConfirmationToken(String confirmationToken);
}
