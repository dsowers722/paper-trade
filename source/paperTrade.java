import java.util.Scanner;

public class paperTrade {
    public static String username;
    public static String password;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Username:");
        username = scan.nextLine();
        System.out.println("Password:");
        password = scan.nextLine();
        Account account = new Account(username, password);
        account.Start();
    }
}
