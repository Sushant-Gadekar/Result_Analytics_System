import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Admin extends User {

    ArrayList<Student> students = new ArrayList<>();

    public Admin(String id, String password) {
        super(id, password);
    }

    // Add student (GUI compatible)
    public void addStudent(Student s) {

        // Duplicate seat check
        for (Student st : students) {
            if (st.getSeatNumber() == s.getSeatNumber()) {
                System.out.println("Seat number already exists!");
                return;
            }
        }

        students.add(s);
    }

    // Find student (login)
    public Student findStudent(int seat, String pass) {
        for (Student s : students) {
            if (s.getSeatNumber() == seat && s.getPassword().equals(pass)) {
                return s;
            }
        }
        return null;
    }

    // Single topper
    public String getTopper() {
        if (students.isEmpty()) return "No students available";

        Student top = students.get(0);

        for (Student s : students) {
            if (s.getTotalMarks() > top.getTotalMarks()) {
                top = s;
            }
        }

        return "Topper: " + top.getName() +
               "\nSeat: " + top.getSeatNumber() +
               "\nMarks: " + top.getTotalMarks();
    }

    // Top 5 overall
    public String getTop5Overall() {
        if (students.isEmpty()) return "No students available";

        ArrayList<Student> temp = new ArrayList<>(students);

        Collections.sort(temp, (a, b) -> b.getTotalMarks() - a.getTotalMarks());

        String result = "🏆 Top 5 Overall:\n";
        int limit = Math.min(5, temp.size());

        for (int i = 0; i < limit; i++) {
            Student s = temp.get(i);
            result += (i + 1) + ". " + s.getName() +
                      " (" + s.getTotalMarks() + ")\n";
        }

        return result;
    }

    // Subject toppers (Top 5 each)
    public String getTop5BySubject() {
        if (students.isEmpty()) return "No students available";

        String result = "";

        result += "\n📘 JAVA Top 5:\n" + getTopByComparator((a, b) -> b.getSsMarks() - a.getSsMarks());
        result += "\n📗 MATH Top 5:\n" + getTopByComparator((a, b) -> b.getCsMarks() - a.getCsMarks());
        result += "\n📙 ENGLISH Top 5:\n" + getTopByComparator((a, b) -> b.getOopMarks() - a.getOopMarks());
        result += "\n📕 EVS Top 5:\n" + getTopByComparator((a, b) -> b.getAimlMarks() - a.getAimlMarks());

        return result;
    }

    // Helper method
    private String getTopByComparator(Comparator<Student> comp) {

        ArrayList<Student> temp = new ArrayList<>(students);
        Collections.sort(temp, comp);

        String res = "";
        int limit = Math.min(5, temp.size());

        for (int i = 0; i < limit; i++) {
            Student s = temp.get(i);
            res += (i + 1) + ". " + s.getName() + "\n";
        }

        return res;
    }
}