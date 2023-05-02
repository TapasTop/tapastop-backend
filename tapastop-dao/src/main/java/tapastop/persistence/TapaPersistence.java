package tapastop.persistence;

import tapastop.model.Restaurant;
import tapastop.model.Tapa;
import tapastop.model.User;

import java.util.List;
import java.util.Optional;

public interface TapaPersistence {
    public Optional<Tapa> findById(Long id);
    public Tapa save(Tapa tapa);
    public List<Tapa> findAll();
    public void deleteById(Long id);
    public List<Tapa> findAllByUsers(User user);
}
