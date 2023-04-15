package tapastop.converters;

import tapastop.model.User;
import tapastop.requests.SaveUserRequest;
import org.springframework.core.convert.converter.Converter;
import tapastop.utils.ValidatorUtils;


public class UserRequestConverter implements Converter<SaveUserRequest, User> {
    @Override
    public User convert(SaveUserRequest source) {
        User user = new User(
                source.getUsername(),
                source.getPassword(),
                ValidatorUtils.mailStringValidator(source.getMail(),  "\"mail\""),
                ValidatorUtils.alphabeticStringValidator(source.getName(), "\"name\""),
                ValidatorUtils.alphabeticStringValidator(source.getSurname(), "\"surname\""),
                ValidatorUtils.dateValidator(source.getBirthdate(), "\"birthdate\""),
                source.getGender(),
                source.getAddress()
                );
        return user;
    }
}
