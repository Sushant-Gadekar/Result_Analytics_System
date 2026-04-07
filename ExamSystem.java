import java.util.Scanner;

public class ExamSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Admin admin = new Admin("Sushant09", "9090");

        int choice;

        do {
            System.out.println("\n1. Admin Login");
            System.out.println("2. Student Login");
            System.out.println("3. Exit");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine();
                    System.out.print("Enter ID: ");
                    String id = sc.nextLine();

                    System.out.print("Enter Password: ");
                    String pass = sc.nextLine();

                    if (admin.login(id, pass)) {
                        System.out.println("Login Success");
                    } else {
                        System.out.println("Invalid");
                    }
                    break;

                case 2:
                    System.out.print("Seat: ");
                    int seat = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Password: ");
                    String sp = sc.nextLine();

                    Student s = admin.findStudent(seat, sp);

                    if (s != null) {
                        System.out.println(s.getResultText());
                    } else {
                        System.out.println("Invalid");
                    }
                    break;
            }

        } while (choice != 3);
    }
}