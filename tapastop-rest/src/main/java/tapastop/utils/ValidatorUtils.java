package tapastop.utils;

import org.springframework.http.HttpStatus;
import tapastop.exceptions.types.BadRequestException;

public class ValidatorUtils{

    private static <T> String stringValidator (T object, String field ){
        if(object == null || !(object.getClass().equals(String.class))){
            throw new BadRequestException("400", "String type was expected in field: " + field, HttpStatus.BAD_REQUEST);
        }
        return (String) object;
    }

    public static <T> String alphabeticStringValidator (T object, String field){
        String str = stringValidator(object, field);
        if(!str.matches(StrTypes.STR_ALPHABETIC)){
            throw new BadRequestException("400", "Alphabetic String was expected, in field: " + field, HttpStatus.BAD_REQUEST);
        }
        return str;
    }

    public static <T> String mailStringValidator (T object, String field){
        String str = stringValidator(object, field);
        if(!str.matches(StrTypes.STR_MAILS)){
            throw new BadRequestException("400", "Mail String was expected, in field: " + field, HttpStatus.BAD_REQUEST);
        }
        return str;
    }

    public static <T> String decNumStringValidator (T object, String field){
        String str = stringValidator(object, field);
        if(!str.matches(StrTypes.STR_DECNUMBER)){
            throw new BadRequestException("400", "Decimal number String was expected, in field: " + field, HttpStatus.BAD_REQUEST);
        }
        return str;
    }

    public static <T> String telephoneNumStringValidator (T object, String field){
        String str = stringValidator(object, field);
        if(!str.matches(StrTypes.STR_NUMBER)){
            throw new BadRequestException("400", "Phone number String was expected, in field: " + field, HttpStatus.BAD_REQUEST);
        }
        return str;
    }

    private static <T> Double doubleValidator (T object, String field){
        if(object == null || !(object.getClass().equals(Double.class))){
            throw new BadRequestException("400", "Double was expected in field: " + field, HttpStatus.BAD_REQUEST);
        }
        return (Double) object;
    }

    /*
    private static <T> Date dateValidator (T object, String field){

    }
*/
    public static <T> Double positiveDoubleValidator (T object, String field){
        Double dbl = doubleValidator(object, field);
        if(dbl < 0){
            throw new BadRequestException("400", "Positive Double was expected, but receive a negative one, in field: " + field, HttpStatus.BAD_REQUEST);
        }
        return dbl;
    }

    public static <T> Double percentDoubleValidator(T object, String field){
        Double dbl = doubleValidator(object, field);
        if(!(0 <= dbl && dbl >= 1)){
            throw new BadRequestException("400", "Percent Double was expected, but receive a negative one, in field: " + field, HttpStatus.BAD_REQUEST);
        }
        return dbl;
    }

    private static <T> Long longValidator (T object, String field){
        if(object == null || !(object.getClass().equals(Long.class))){
            throw new BadRequestException("400", "Long type was expected in field: " + field, HttpStatus.BAD_REQUEST);
        }
        return (Long) object;
    }

    public static <T> Long positiveLongValidator (T object, String field){
        Long lng = longValidator(object, field);
        if(lng < 0){
            throw new BadRequestException("400", "Positive Double was expected, but receive a negative one, in field: " + field, HttpStatus.BAD_REQUEST);
        }
        return lng;
    }
}