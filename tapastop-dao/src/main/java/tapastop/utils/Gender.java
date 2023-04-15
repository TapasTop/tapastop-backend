package tapastop.utils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum Gender {
    TYPE1("MALE"),
    TYPE2("FEMALE"),
    TYPE3("OTHER");

    private String code;

    private Gender(String code) {
        this.code=code;
    }

    @JsonCreator
    public static Gender decode(final String code) {
        return Stream.of(Gender.values()).filter(targetEnum -> targetEnum.code.equals(code)).findFirst().orElse(null);
    }

    @JsonValue
    public String getCode() {
        return code;
    }

}
