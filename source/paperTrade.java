import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class paperTrade {
    
    private static ArrayList<Account> accounts = new ArrayList<>();
    private static final String directory = System.getProperty("user.dir") + "/Accounts.ser";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Username:");
        String username = scan.nextLine();
        System.out.println("Password:");
        String password = scan.nextLine();
        ReadData();
        if (!checkForAccount(username)) {
            Account account = new Account(username, password);
            accounts.add(account);
            WriteData(accounts);
        }
    }

    public static void WriteData(ArrayList<Account> accountList) {
        try (ObjectOutputStream objectOutStream = new ObjectOutputStream(new FileOutputStream(directory))){
            objectOutStream.writeObject(accountList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ReadData() {
        try (ObjectInputStream objectInStream = new ObjectInputStream(new FileInputStream(directory))) {
            accounts = (ArrayList<Account>)objectInStream.readObject();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static boolean checkForAccount(String username) {
        System.out.println(accounts.size());
        for (Account account : accounts) {
            System.out.println(account.getUsername());
            if (account.getUsername().equals(username)) {
                System.out.println("Account with the given username already exists!\n" +
                                   "Please try again.");
                return true;
            }
        }
        return false;
    }
}
