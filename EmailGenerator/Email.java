package EmailGenerator;

import java.util.Scanner;

public class Email {

    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private int mailboxCapacity;
    private String alternateEmail;
    private int defaultPasswordLength = 15;
    private String email;

    private String companySuffix = "google";
    public Email(String firstName,String lastName){
        this.firstName = firstName;
        this.lastName = lastName;

        System.out.println("first name: "+this.firstName +" last name: "+this.lastName);
        this.department = setDepartment();
//        System.out.println("Department: "+this.department);
        this.password = generator(defaultPasswordLength);
//        System.out.println("Your newly generated password is: "+password);

        email = this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + department + "." + companySuffix + ".com";
        System.out.println("Email: "+ email + " password: "+ password);


        options();
    }

    private void options(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Options: ");
            System.out.println("1).Set new Alternate Email");
            System.out.println("2).Set new Password");
            System.out.println("3).Generate New Password");
            System.out.println("4).Select other Department");
            System.out.println("5).Set mailbox capacity");
            System.out.println("6).None");
            int opt = sc.nextInt();
            if(opt == 1){
                System.out.print("Enter new Alternate Email: ");
                String newAltEmail = sc.next();
                setAlternateEmail(newAltEmail);
                System.out.println("Alternate Email Updated.");
            }
            else if(opt == 2){
                System.out.print("Enter new Password: ");
                String newPassword = sc.next();
                System.out.println();
                changePassword(newPassword);
            }
            else if(opt == 3){
                System.out.print("Newly Generated password");
                generatePasswordAgain();
            }
            else if(opt == 4){
                System.out.print("Select new Department: ");
                this.department = setDepartment();
                email = this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + department + "." + companySuffix + ".com";
                System.out.println("Email: "+ email + " password: "+ password);
            }
            else if(opt == 5){
                System.out.println("Enter mailbox capacity: ");
                int cap = sc.nextInt();
                setMailboxCapacity(cap);
                System.out.println("Mail capacity Updated");
            }
            else{
                break;
            }
        }
    }
    private String setDepartment(){
        System.out.println("Enter the department");
        System.out.println("1). for sales");
        System.out.println("2). for Development");
        System.out.println("3). for Accounting");
        System.out.println("4). for Management");
        System.out.println("5). for Testing");
        System.out.println("6). for Human Resource");
        System.out.println("7). for Service");
        System.out.println("8). for Research & Development");
        System.out.println("9). None");
        System.out.print("Enter your choice: ");
        System.out.println();

        Scanner sc = new Scanner(System.in);
        int depChoice = sc.nextInt();

        if(depChoice == 1){
            return "sales";
        }
        else if(depChoice == 2){
            return "Development";
        }
        else if(depChoice == 3){
            return "Accounting";
        }
        else if(depChoice == 4){
            return "Management";
        }
        else if(depChoice == 5){
            return "Testing";
        }
        else if(depChoice == 6){
            return "HumanResource";
        }
        else if(depChoice == 7){
            return "Service";
        }
        else if(depChoice == 8){
            return "Research&Dev";
        }
        else{
            return "";
        }

    }

    private String generator(int length){

        String set = "ABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*123456789abcdefghijklmnopqrstuvwxyz";
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int random = (int) (Math.random() * set.length());
            password.append(set.charAt(random));
        }

        return password.toString();
    }

    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }
    public void changePassword(String password){
        this.password = password;
        System.out.println("Email: "+ email + " password: " + password);
    }

    public void generatePasswordAgain(){
        String newPassword = generator(defaultPasswordLength);
        this.password = newPassword;
        System.out.println("Email: "+ email + " password: " + password);
    }

}
