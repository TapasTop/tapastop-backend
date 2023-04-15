package tapastop.services;

import org.springframework.http.ResponseEntity;
import tapastop.model.User;

import java.util.List;

public interface UserService {
    public User findById(Long id);
    public ResponseEntity<String> save(User user);
    public List<User> findAll();
    public void deleteById(Long id);
    public User findByMail(String mail);
    public ResponseEntity<String> confirmEmail(String confirmationToken);
}