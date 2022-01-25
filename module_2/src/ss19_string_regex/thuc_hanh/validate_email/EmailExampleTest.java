package ss19_string_regex.thuc_hanh.validate_email;

public class EmailExampleTest {
    private static EmailExample emailExample;
    public static final String[] validate = new String[] {"a@gmail.com", "ab@yahoo.com", "abc@hotmail.com"};
    public static final String[]   invalidate = new String[]{"@gmail.com", "ab@gmail.", "@#abc@gmail.com" };

    public static void main(String[] args) {
        emailExample =new EmailExample();
        for (String email: validate){
            boolean isValidate = emailExample.validate(email);
            System.out.println("Email is "+ email + " is validate "+ isValidate);
        }
        for (String email: invalidate){
            boolean isValidate = emailExample.validate(email);
            System.out.println("Email is "+ email + " is validate "+ isValidate);
        }
    }
}
