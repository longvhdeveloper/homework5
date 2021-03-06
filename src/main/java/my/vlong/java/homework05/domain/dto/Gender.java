package my.vlong.java.homework05.domain.dto;

public enum Gender {
    MALE(1), FEMALE(0), UNKNOWN(-1);
    private int code;

    Gender(int code) {
        this.code = code;
    }

    public static Gender map(int code) {
        switch (code) {
            case 1:
                return MALE;
            case 0:
                return FEMALE;
            case -1:
                return UNKNOWN;
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public static String getValue(Gender gender) {
        switch (gender) {
            case MALE:
                return "Male";
            case FEMALE:
                return "Female";
            case UNKNOWN:
                return "Unknown";
        }
        return "";
    }
}
