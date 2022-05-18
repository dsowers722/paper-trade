import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class paperTrade {
    private static ArrayList<Account> accounts = new ArrayList<>();
    private static Boolean exists;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Username:");
        String username = scan.nextLine();
        System.out.println("Password:");
        String password = scan.nextLine();
        ReadData();
        checkForAccount(username);
        if (!exists) {
            Account account = new Account(username, password);
            WriteData(account);
        }
    }

    public static void WriteData(Account accountWrite) {
        try {
            ObjectOutputStream objectOutStream = new ObjectOutputStream(new FileOutputStream(System.getProperty("user.dir"), true));
            objectOutStream.writeObject(accountWrite);
            objectOutStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ReadData() {
        try {
            ObjectInputStream objectInStream = new ObjectInputStream(new FileInputStream(System.getProperty("user.dir")));
            while (true) {
                try {
                    accounts.add((Account) objectInStream.readObject());
                } catch (EOFException eofException) {
                    break;
                }
            }
            objectInStream.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void checkForAccount(String username) {
        for (Account account : accounts) {
            if (account.getUsername().equals(username)) {
                System.out.println("Account with the given username already exists!\n" +
                                   "Please try again.");
                exists = true;
            }
        }
        exists = false;
    }
}
