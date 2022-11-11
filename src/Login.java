import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login {
    private String userName;
    private String password;
    private String contactName;
    private String  mobileNumber;
    private String address;
    private String relationship;
    ArrayList<Contact> contacts = new ArrayList<>();
    ArrayList<Contact> favorites = new ArrayList<>();


    Login(String userName, String password){
        this.userName = userName;
        this.password = password;
    }

    public void contactOptions(){
        contacts.add(new Contact("Karthik","9874682728","Trichy","Friend"));
        contacts.add(new Contact("Barath","9374882323","Kanchipuram","Friend"));
        contacts.add(new Contact("vijay","8954682728","vellore","Brother"));
        while(true){

            System.out.println("\n[1]. Add Contact");
            System.out.println("[2]. Delete");
            System.out.println("[3]. Search");
            System.out.println("[4]. Contact List");
            System.out.println("[5]. Edit");
            System.out.println("[6]. Add Favourite");
            System.out.println("[7]. Favorites");
            System.out.println("[8]. Exit\n");

            int userInput = 0;
            try {
                userInput = Integer.parseInt(SignUp.input.nextLine());
            }catch (Exception e){
                //System.err.println("Invalid input");
                //input.nextLine();
            }
            if(!(userInput >= 1 && userInput <= 8)){
                System.err.println("Invalid Input!!!");
                continue;
            }

            switch (userInput){
                case 1:{
                    System.out.println("\t\t****** Add Contact ******\n\n");
                    System.out.print("Contact Name : ");
                    contactName = SignUp.input.next();
//                    SignUp.input.nextLine();
//                    System.out.print("\nMobile Number : ");
                    mobileNumber = isValidMobileNumber();
//                    SignUp.input.nextLine();
                    System.out.print("\nAddress : ");
                    address = SignUp.input.next();
                    SignUp.input.nextLine();
                    System.out.print("\nRelationship : ");
                    relationship = SignUp.input.next();
                    SignUp.input.nextLine();
                    for(Contact contact:contacts){
                        if(contact.getContactName().equals(contactName)){
                            System.out.println("This Name is Already Exist\n");
                            System.out.println("Enter Another Name");
                            contactName = SignUp.input.next();
                            SignUp.input.nextLine();
                        }
                    }

//                    Pattern pattern = Pattern.compile("^[0-9]{10}$");
//                    Matcher matcher = pattern.matcher(mobileNumber);
//                    if(matcher.find()){
                        Contact contact = new Contact(contactName,mobileNumber,address,relationship);
                        contacts.add(contact);
                        System.out.println("\n***** Contact Created Successfully *****\n");
//                    }
//                    else
//                        System.err.println("\n***** Invalid Mobile Number *****\n");
                    break;
                }
                case 2 :{
                    System.out.println("\t\t**** Delete ****\n\n");
                    System.out.print("Enter the Contact you want to delete : ");
                    contactName = SignUp.input.next();
                    SignUp.input.nextLine();
                    boolean flag = true;
                    for(Contact contact:contacts){
                        if(contact.getContactName().equals(contactName)){
                            contacts.remove(contact);
                            favorites.remove(contact);
                            System.out.println("\t\t****** Deleted Successfully ******\n");
                            flag = false;
                            break;
                        }
                    }
                    if (flag){
                        System.err.println("Contact Not Found");
                    }
                    break;
                }
                case 3 :{
                    System.out.println("\t\t**** Search ****\n\n");
                    System.out.print("Enter the Contact you Want to Search : ");
                    contactName = SignUp.input.next();
                    SignUp.input.nextLine();
                    String name = contactName.toLowerCase();
                    if(contacts.size()!=0) {
                        boolean flag = true;
                        for (Contact contact : contacts) {
                            if (contact.getContactName().toLowerCase().contains(name)) {
                                System.out.println("\nName     : " + contact.getContactName());
                                System.out.println("Number   : " + contact.getMobileNumber());
                                System.out.println("Address  : " + contact.getAddress());
                                System.out.println("Relation : " + contact.getRelationship() + "\n");
                                flag = false;
//                                break;
                            }

                        }
                        if(flag)
                            System.err.println(" Contact Not Found ");
                    }
                    else
                        System.out.println("No contacts Yet ");
                    break;
                }
                case 4 : {
                    System.out.println("\t\t****** CONTACTS ******\n\n");
                    if (contacts.size() != 0) {
                        System.out.println("+___________________________________________________________________________+");
                        System.out.printf("| %-4s| %-15s| %-15s| %-17s| %-15s|","S.No","Name","Phone Number","City","Relation");
                        System.out.println("\n+___________________________________________________________________________+");
                        int i = 0;
                        for (Contact contact : contacts) {
                            System.out.printf("| %-4d| %-15s| %-15s| %-17s| %-15s|\n",++i,contact.getContactName(),
                                    contact.getMobileNumber(),contact.getAddress(),contact.getRelationship());
                        }
                        System.out.println("+___________________________________________________________________________+\n");
                    }else
                        System.out.println("No contact Yet ");
                    break;
                }
                case 5 : {
                    System.out.println("\t\t****** EDIT ******\n\n");
                    System.out.println("[1]. Name\n[2]. Mobile Number");
                    int editInput = SignUp.input.nextInt();
                    if(editInput == 1 || editInput == 2){
                        if(editInput == 1){
                            System.out.print("Old Name : ");
                            contactName = SignUp.input.next();
                            SignUp.input.nextLine();
                            boolean flag = true;
                            for(Contact contact:contacts){
                                if(contact.getContactName().equals(contactName)){
                                    System.out.print("New Name : ");
                                    String newName = SignUp.input.next();
                                    SignUp.input.nextLine();
                                    contact.setContactName(newName);
                                    System.out.println("Name changed");
                                    flag = false;
                                    break;
                                }
                            }
                            if(flag)
                                System.err.println("Name Not in Contacts");
                        }
                        else {

                            System.out.print("Old Number : ");
                            mobileNumber = SignUp.input.next();
                            SignUp.input.nextLine();
                            boolean flag = true;
                            for(Contact contact:contacts){
                                if(contact.getMobileNumber().equals(mobileNumber)){
                                    System.out.print("New Number : ");
                                    String newNumber = SignUp.input.next();
                                    SignUp.input.nextLine();
                                    contact.setMobileNumber(newNumber);
                                    System.out.println("Number Changed");
                                    flag = false;
                                    break;
                                }
                            }
                            if(flag)
                                System.err.println("Name Not in Contacts");

                        }
                    }
                    else
                        System.err.println("Invalid Input !!!");
                    break;
                }
                case 6 : {
                    System.out.print("Enter your Favourite contact : ");
                    contactName = SignUp.input.next();
                    SignUp.input.nextLine();
                    boolean value = false;
                    for(Contact favorite: favorites){
                        if(favorite.getContactName().equals(contactName)){
                            System.out.println("This Contact is Already Added in Favourite list");
                            value = true;
                            break;
                        }
                    }
                    if(value)
                        break;


                    boolean flag = true;
                    for (Contact contact: contacts){
                        if(contact.getContactName().equals(contactName)){
                            favorites.add(contact);
                            System.out.println(contactName+" is Added into Favorite");
                            flag = false;
                            break;
                        }
                    }
                    if(flag)
                        System.out.println("Contact Not Found");
                    break;
                }
                case 7 : {
                    System.out.println("\t\t****** FAVOURITES ******\n\n");
                    if(favorites.size()==0){
                        System.out.println("No favourites Yet ");
                    }
                    else {
                        System.out.println("+_____________________________________________________________________+");
                        System.out.printf("| %-15s| %-15s| %-17s| %-15s|","Name","Phone Number","City","Relation");
                        System.out.println("\n+_____________________________________________________________________+");
                        for(Contact contact: favorites){
                            System.out.printf("| %-15s| %-15s| %-17s| %-15s|\n",contact.getContactName(),
                                    contact.getMobileNumber(),contact.getAddress(),contact.getRelationship());
                        }
                        System.out.println("+_____________________________________________________________________+\n");
                    }
                    break;
                }
                case 8 : {
                    System.out.println("\t\t****** Thank You ******");
                    System.exit(0);
                }
            }
        }

    }
    public static String isValidMobileNumber(){
        SignUp.input.nextLine();
        while (true) {
            System.out.print("\nMobile Number : ");
            String mobileNumber = SignUp.input.nextLine();
            Pattern pattern = Pattern.compile("^[0-9]{10}$");
            Matcher matcher = pattern.matcher(mobileNumber);
            if (matcher.find()) {
                return mobileNumber;
            } else {
                System.out.println("\nInvalid Mobile Number");
            }
        }
    }

}
