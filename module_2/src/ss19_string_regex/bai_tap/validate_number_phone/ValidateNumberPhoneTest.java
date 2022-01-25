package ss19_string_regex.bai_tap.validate_number_phone;

public class ValidateNumberPhoneTest {
    public static void main(String[] args) {
        String[] validateNumberPhone = new String[]{"(84)-(0978489648)","(84)-(0978567648)","(34)-(0979889128)"};
        String[] invalidateNumberPhone = new String[]{"(a4)-(2222222222)","(84)-(35423452345)","(34)-(097988912854)"};
        for (String numberPhone : validateNumberPhone) {
            System.out.println("Number "+ numberPhone + "is validate "+ isValidatePhoneNumber(numberPhone));
        }
        for (String numberPhone : invalidateNumberPhone) {
            System.out.println("Number "+ numberPhone + "is validate "+ isValidatePhoneNumber(numberPhone));
        }
    }

    public static  boolean isValidatePhoneNumber(String number){
        String regex = "^[(]\\d{2}[)]-[(][0]\\d{9}[)]$";
        return number.matches(regex);
    }
}
