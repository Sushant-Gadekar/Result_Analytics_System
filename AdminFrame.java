import javax.swing.*;

class AdminFrame extends JFrame {

    Admin admin;

    public AdminFrame(Admin admin) {
        this.admin = admin;

        setTitle("Admin Panel");
        setSize(400, 350);
        setLayout(null);

        JButton addBtn = new JButton("Add Student");
        addBtn.setBounds(100, 30, 180, 30);
        add(addBtn);

        JButton topperBtn = new JButton("Show Topper");
        topperBtn.setBounds(100, 80, 180, 30);
        add(topperBtn);

        JButton top5Btn = new JButton("Top 5 Overall");
        top5Btn.setBounds(100, 130, 180, 30);
        add(top5Btn);

        JButton subjectBtn = new JButton("Top 5 Subjects");
        subjectBtn.setBounds(100, 180, 180, 30);
        add(subjectBtn);

        JButton backBtn = new JButton("Logout");
        backBtn.setBounds(100, 230, 180, 30);
        add(backBtn);

        // ➕ Add Student
        addBtn.addActionListener(e -> {
            try {
                String name = JOptionPane.showInputDialog("Enter Name:");
                int seat = Integer.parseInt(JOptionPane.showInputDialog("Enter Seat Number:"));
                String pass = JOptionPane.showInputDialog("Create Password:");

                int java = Integer.parseInt(JOptionPane.showInputDialog("SS Marks:"));
                int math = Integer.parseInt(JOptionPane.showInputDialog("CS Marks:"));
                int eng = Integer.parseInt(JOptionPane.showInputDialog("OOP Marks:"));
                int evs = Integer.parseInt(JOptionPane.showInputDialog("AIML Marks:"));

                admin.addStudent(new Student(name, seat, pass, java, math, eng, evs));

                JOptionPane.showMessageDialog(this, "Student Added Successfully!");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid Input!");
            }
        });

        // 🏆 Topper
        topperBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, admin.getTopper());
        });

        // 🥇 Top 5 Overall
        top5Btn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, admin.getTop5Overall());
        });

        // 📊 Subject Top 5
        subjectBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, admin.getTop5BySubject());
        });

        // 🔙 Logout
        backBtn.addActionListener(e -> {
            new LoginFrame(admin);
            dispose();
        });

        setVisible(true);
    }
}