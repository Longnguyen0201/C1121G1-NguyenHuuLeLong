package ss19_string_regex.thuc_hanh.validate_account;

public class AccountExampleTest {
    private static AccountExample accountExample;

    private static final  String[] validateAccount = new String[]{"123abc_", "_abc123", "______", "123456","abcdefgh"};
    private static final String[] invalidateAccount = new String[]{".@", "12345", "1234_", "abcde" };

    public static void main(String[] args) {
        accountExample = new AccountExample();
        for (String account : validateAccount) {
            boolean isValidate = accountExample.validate(account);
            System.out.println("Account is "+ account + " is validate "+ isValidate);
        }
        for (String account : invalidateAccount) {
            boolean isValidate = accountExample.validate(account);
            System.out.println("Account is "+ account + " is validate "+ isValidate);
        }
    }
}
