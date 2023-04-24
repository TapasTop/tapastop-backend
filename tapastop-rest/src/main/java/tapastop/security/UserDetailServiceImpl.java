package tapastop.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tapastop.model.User;
import tapastop.persistence.UserPersistence;
import tapastop.services.UserService;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserPersistence userPersistence;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userPersistence.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario " + username + " no existe."));
        return new UserDetailsImpl(user);
    }
}
