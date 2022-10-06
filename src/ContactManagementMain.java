import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactManagementMain {

    static Scanner input = new Scanner(System.in);
    static String username;
    static String password;
    static ArrayList<SignUp> signUps = new ArrayList<>();

    public static void main(String[] args) {
        signUps.add(new SignUp("vikram","Maxstuart2@"));
        while ((true)){
            System.out.println("[1].Sign Up ");
            System.out.println("[2].Login");
            System.out.println("[3].Exit\n");
            int userInput = Integer.parseInt(input.nextLine());

            
            if(!(userInput >=1 && userInput<=3))
                continue;
            if(userInput == 1){
                System.out.println("\t\t****** Signup ******\n\n");
                System.out.print("Enter Your UserName : ");
                username = input.next();
                //input.nextLine();
                System.out.print("Enter Your Password : ");
                password = input.next();
                //input.nextLine();

                while (true){

                    Pattern pattern = Pattern.compile("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9s])(?=.*[@#$%]).{8,20}$");
                    Matcher matcher = pattern.matcher(password);
                    if(matcher.matches()){
//                        System.out.println(matcher.find());
                        break;
                    }
                    else {
//                        System.out.println(matcher.find());
                        System.out.println("\nPassword must contains at least 1 number,1 capital letter,1 small letter " +
                                "and" + " 1 special character");
                        System.out.println(" Example: \"Password123@\"\n");
                        System.out.print("Enter Your Password : ");
                        password = input.next();
                        input.nextLine();
                    }
                }

            }

            switch (userInput){
                case 1:{



                    SignUp signUp = new SignUp(username,password);

                    signUps.add(signUp);
                    System.out.println("\t\t****** Signup successfully ******\n\n");
                    break;
                }

                case 2:{
                    System.out.println("\t\t****** Login ******\n\n");
                    System.out.print("Enter Your UserName : ");
                    username = input.next();
                    input.nextLine();
                    System.out.print("Enter Your Password : ");
                    password = input.next();
                    input.nextLine();
                    boolean flag = true;
                    for(SignUp signUp:signUps){
                        if(signUp.getUserName().equals(username) && signUp.getPassword().equals(password)){
                            System.out.println("\n\t\t**** Login Successfully ****\n");
                            Login login = new Login(username,password);
                            login.contactOptions();
                            flag = false;
                        }
                    }
                    if(flag){
                        System.out.println("\n**** Invalid Username or Password ****\n");
                    }
                    break;
                }

                case 3 :{
                    System.out.println("****** Thank You! ******");
                    System.exit(0);
                }
            }
        }
    }
}
