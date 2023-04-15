package tapastop.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import tapastop.model.ConfirmationToken;
import tapastop.model.User;
import tapastop.persistence.ConfirmationTokenPersistence;
import tapastop.persistence.UserPersistence;
//import tapastop.services.EmailService;
import tapastop.services.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    //@Autowired
    //private EmailService emailService;

    @Autowired
    private UserPersistence userPersistence;

    @Autowired
    private ConfirmationTokenPersistence confirmationTokenPersistence;

    @Override
    public User findById(Long id) {
        Optional<User> user = userPersistence.findById(id);
        return user.get();
    }

    @Override
    public ResponseEntity<String> save(User user) {
        if(userPersistence.findByMail(user.getMail()).isPresent()){
            return ResponseEntity.badRequest().body("Error: Email is already in use");
        }

        userPersistence.save(user);

        ConfirmationToken confirmationToken = new ConfirmationToken(user);
        confirmationTokenPersistence.save(confirmationToken);

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(user.getMail());
        mailMessage.setSubject("Confirma tu registro");
        mailMessage.setText("Su registro se ha realizado con éxito, ahora solo falta el último paso. Verifica tu " +
                "cuenta en el siguiente enlace: http://localhost:8080/confirm-account?token?" +
                confirmationToken.getConfirmationToken());
        //emailService.sendEmail(mailMessage);

        return new ResponseEntity<>("Operation successfully", HttpStatus.OK);
    }

    @Override
    public List<User> findAll() {
        List<User> userList = userPersistence.findAll();
        return null;
    }

    @Override
    public void deleteById(Long id) {
        userPersistence.deleteById(id);
    }

    @Override
    public User findByMail(String mail) {
        Optional<User> user = userPersistence.findByMail(mail);
        return user.get();
    }

    @Override
    public ResponseEntity<String> confirmEmail(String confirmationToken) {
        Optional<ConfirmationToken> token = confirmationTokenPersistence.findByConfirmationToken(confirmationToken);
        if(token.isPresent()){
            User user = userPersistence.findByMail(token.get().getUser().getMail()).get();
            user.setEnabled(true);
            userPersistence.save(user);
            return ResponseEntity.ok("Email verified successfully");
        }
        return ResponseEntity.badRequest().body("Error: Couldn't verify the email");
    }
}
