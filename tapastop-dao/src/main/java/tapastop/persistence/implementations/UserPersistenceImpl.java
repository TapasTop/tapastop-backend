package tapastop.persistence.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tapastop.dao.UserDao;
import tapastop.model.User;
import tapastop.persistence.UserPersistence;

import java.util.List;
import java.util.Optional;

@Component
public class UserPersistenceImpl implements UserPersistence {

    @Autowired
    private UserDao userDao;

    @Override
    public Optional<User> findById(Long id) {
        Optional<User> persisted = this.userDao.findById(id);
        return persisted;
    }

    @Override
    public User save(User user) {
        User persisted = this.userDao.save(user);
        return persisted;
    }

    @Override
    public List<User> findAll() {
        List<User> persisted = this.userDao.findAll();
        return persisted;
    }

    @Override
    public void deleteById(Long id) {
        this.userDao.deleteById(id);
    }

    @Override
    public Optional<User> findByMail(String mail) {
        Optional<User> persisted = this.userDao.findUserByMail(mail);
        return persisted;
    }
}
