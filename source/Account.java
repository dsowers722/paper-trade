public class Account {
    String username;
    String password;
    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public void Start() {
        System.out.println("Start");
    }
}
