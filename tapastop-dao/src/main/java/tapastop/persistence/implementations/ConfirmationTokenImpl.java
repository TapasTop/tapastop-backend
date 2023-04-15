package tapastop.persistence.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tapastop.dao.ConfirmationTokenDao;
import tapastop.model.ConfirmationToken;
import tapastop.model.User;
import tapastop.persistence.ConfirmationTokenPersistence;

import java.util.Optional;

@Component
public class ConfirmationTokenImpl implements ConfirmationTokenPersistence {

    @Autowired
    private ConfirmationTokenDao confirmationTokenDao;

    @Override
    public ConfirmationToken save(ConfirmationToken confirmationToken) {
        ConfirmationToken persisted = this.confirmationTokenDao.save(confirmationToken);
        return persisted;
    }

    @Override
    public Optional<ConfirmationToken> findByConfirmationToken(String confirmationToken) {
        Optional<ConfirmationToken> persisted = this.confirmationTokenDao.findByConfirmationToken(confirmationToken);
        return persisted;
    }
}
