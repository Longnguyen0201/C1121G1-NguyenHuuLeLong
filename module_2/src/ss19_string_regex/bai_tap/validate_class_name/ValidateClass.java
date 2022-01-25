package ss19_string_regex.bai_tap.validate_class_name;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateClass {
    private static final String CLASS_NAME_REGEX ="^[CAP]\\d{4}[GHIKLM]$";

    public ValidateClass() {
    }

    public boolean validateClass(String string){
        return string.matches(CLASS_NAME_REGEX);
    }
}
