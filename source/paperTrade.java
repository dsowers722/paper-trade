import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class paperTrade {

    private static ArrayList<Account> accounts = new ArrayList<>();
    private static final String directory = System.getProperty("user.dir") + "/Accounts.ser";
    static Account account = null;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("(Please enter a username and password." +
                " If the username does not exist an account will be created)");
        System.out.println("Username:");
        String username = scan.nextLine();
        System.out.println("Password:");
        String password = scan.nextLine();

        // This is to just check if the file exists if doesn't exist, create the file.
        if (((new File(directory)).exists()) && ((new File(directory)).length() != 0)) {
            ReadData();
            if (!checkForAccount(username, password)) {
                Account accountToAdd = new Account(username, password);
                accounts.add(accountToAdd);
                account = accountToAdd;
                WriteData(accounts);
            }
        } else {
            Account newAccount = new Account(username, password);
            accounts.add(newAccount);
            account = newAccount;
            WriteData(accounts);
        }
    }

    public static void WriteData(ArrayList<Account> accountList) {
        try (ObjectOutputStream objectOutStream = new ObjectOutputStream(new FileOutputStream(directory, false))){
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

    public static boolean checkForAccount(String username, String password) {
        Scanner scanner = new Scanner(System.in);
        for (Account accountToLogin : accounts) {
            if (accountToLogin.getUsername().equals(username)) {
                System.out.println("Account with the given username already exists!\n" +
                        "Would you like to login? Y/N");
                if (scanner.nextLine().equalsIgnoreCase("y")) {
                    if (password.equals(accountToLogin.getPassword())) {
                        System.out.println("Login successful!");
                        account = accountToLogin;
                        return true;
                    } else {
                        System.out.println("Wrong password!");
                        return true;
                    }
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
