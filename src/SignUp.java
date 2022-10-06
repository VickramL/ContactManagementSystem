import java.util.Scanner;

public class SignUp {
    static Scanner input = new Scanner(System.in);

    private String userName;
    private String password;

    SignUp(String userName,String password){
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
