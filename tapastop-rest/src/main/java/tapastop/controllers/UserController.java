package tapastop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tapastop.converters.UserRequestConverter;
import tapastop.model.User;
import tapastop.requests.SaveUserRequest;
import tapastop.services.UserService;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
        ResponseEntity<User> responseEntity = new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping("/user")
    public ResponseEntity<String> saveUser(@RequestBody SaveUserRequest saveUserRequest){
        UserRequestConverter userRequestConverter = new UserRequestConverter();
        User user = userRequestConverter.convert(saveUserRequest);
        return   userService.save(user);
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllUsers(){
        ResponseEntity<List<User>> responseEntity = new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id){
        userService.deleteById(id);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/user/mail/{mail}")
    public ResponseEntity<User> findUserByMail(@PathVariable String mail){
        ResponseEntity<User> responseEntity = new ResponseEntity<>(userService.findByMail(mail), HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/confirm-account")
    public ResponseEntity<String> confirmUserAccount(@RequestParam String token) {
        return userService.confirmEmail(token);
    }
}
