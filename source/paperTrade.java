import java.util.ArrayList;
import java.util.Scanner;

public class paperTrade {
    private static ArrayList<Account> accounts = new ArrayList<Account>();
    public static void main(String[] args) {
        Boolean accountExists;
        Scanner scan = new Scanner(System.in);
        System.out.println("Username:");
        String username = scan.nextLine();
        System.out.println("Password:");
        String password = scan.nextLine();
        Account account = new Account(username, password);
        ReadData();
    }

    public static void WriteData(Account accountWrite) {

    }

    public static void ReadData() {

    }
}
