package tapastop.persistence;

import tapastop.model.User;

import java.util.List;
import java.util.Optional;

public interface UserPersistence {
    public Optional<User> findById(Long id);
    public User save(User user);
    public List<User> findAll();
    public void deleteById(Long id);
    public Optional<User> findByMail(String mail);
    public Optional<User> findByUsername(String username);
}
