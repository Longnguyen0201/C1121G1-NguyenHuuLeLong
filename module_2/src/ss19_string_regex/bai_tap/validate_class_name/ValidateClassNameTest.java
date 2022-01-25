package ss19_string_regex.bai_tap.validate_class_name;

public class ValidateClassNameTest {
    public static void main(String[] args) {
        ValidateClass validateClass= new ValidateClass();
        String[] validateClassName = new String[]{"C0318G","A0421H","P0119L"};
        String[] invalidateClassName = new String[]{" M0318G", "P0323A ", "H0313K"};

        for (String className : validateClassName) {
            boolean isValidate = validateClass.validateClass(className);
            System.out.println(" Class is "+ className + " is validate " + isValidate);
        }
        for (String className : invalidateClassName) {
            boolean isValidate = validateClass.validateClass(className);
            System.out.println(" Class is "+ className + " is validate " + isValidate);
        }
    }
}
