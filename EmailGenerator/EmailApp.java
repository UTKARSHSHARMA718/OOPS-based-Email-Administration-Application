package EmailGenerator;
import java.util.Scanner;

public class EmailApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please Enter your First name: ");
        String fn = sc.next();
        System.out.print("Please Enter your Last name: ");
        String ln = sc.next();
        System.out.println();
        Email create = new Email(fn,ln);

    }
}
