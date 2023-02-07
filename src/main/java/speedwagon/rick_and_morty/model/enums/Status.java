package speedwagon.rick_and_morty.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum Status {
    ALIVE("Alive"),
    DEAD("Dead"),
    UNKNOWN("Unknown");
    private String value;
    private static Map<String, Status> lookup = new HashMap<>();

    static {
        for (Status s : Status.values()) {
            lookup.put(s.value, s);
        }
    }

    Status(String value) {
        this.value = value;
    }

    public static Status getStatus(String value) {
        return lookup.get(value);
    }
}
