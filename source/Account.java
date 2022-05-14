import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Account {

    String username;
    String password;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public void SaveInfo() {
        try {
            FileWriter fw = new FileWriter("userinfo.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(username + " " + password );
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("Error with file");
        }
    }
}
