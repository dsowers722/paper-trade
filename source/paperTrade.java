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
            ObjectOutputStream objectOutStream = new ObjectOutputStream(new FileOutputStream("Accounts.ser", true));
            objectOutStream.writeObject(accountWrite);
            objectOutStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ReadData() {
        try {
            ObjectInputStream objectInSteam = new ObjectInputStream(new FileInputStream("Accounts.ser"));
            while (true) {
                try {
                    accounts.add((Account) objectInSteam.readObject());
                } catch (EOFException eofException) {
                    break;
                }
            }
            objectInSteam.close();
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
