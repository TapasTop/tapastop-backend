package tapastop.utils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum Taste {

    TYPE1("SWEET"),
    TYPE2("SALTY"),
    TYPE3("SOUR"),
    TYPE4("BITTER"),
    TYPE5("UMAMI");

    private String code;

    private Taste(String code) {
        this.code=code;
    }

    @JsonCreator
    public static Taste decode(final String code) {
        return Stream.of(Taste.values()).filter(targetEnum -> targetEnum.code.equals(code)).findFirst().orElse(null);
    }

    @JsonValue
    public String getCode() {
        return code;
    }
}