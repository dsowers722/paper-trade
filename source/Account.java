import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Account implements Serializable {

    private final String username;
    private final String password;
    private ArrayList<String> stocks = new ArrayList<String>();
    private final String menuOptions = "1- View/buy stock\n" +
            "2- View your stocks\n" +
            "3- Sell your stock";
    private Scanner scanner = new Scanner(System.in);

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public void MenuOptions() {
        System.out.println(menuOptions);
    }
}
