package speedwagon.rick_and_morty.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum Gender {
    FEMALE("Female"),
    MALE("Male"),
    GENDERLESS("Genderless"),
    UNKNOWN("unknown");
    private static Map<String, Gender> lookup = new HashMap<>();
    private String value;

    static {
        for (Gender g : Gender.values()) {
            lookup.put(g.value, g);
        }
    }

    Gender(String value) {
        this.value = value;
    }

    public static Gender getGender(String value) {
        return lookup.get(value);
    }
}
