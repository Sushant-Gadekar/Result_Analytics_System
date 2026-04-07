import javax.swing.*;

class LoginFrame extends JFrame {

    Admin admin;

    public LoginFrame(Admin admin) {
        this.admin = admin;

        setTitle("Login");
        setSize(320, 250);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(30, 30, 80, 25);
        add(idLabel);

        JTextField idField = new JTextField();
        idField.setBounds(120, 30, 150, 25);
        add(idField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(30, 70, 80, 25);
        add(passLabel);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(120, 70, 150, 25);
        add(passField);

        JButton adminBtn = new JButton("Admin Login");
        adminBtn.setBounds(30, 130, 120, 30);
        add(adminBtn);

        JButton studentBtn = new JButton("Student Login");
        studentBtn.setBounds(160, 130, 130, 30);
        add(studentBtn);

        // Admin Login
        adminBtn.addActionListener(e -> {
            String id = idField.getText();
            String pass = passField.getText();

            if (admin.login(id, pass)) {
                new AdminFrame(admin);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Admin Credentials");
            }
        });

        // Student Login
        studentBtn.addActionListener(e -> {
            new StudentFrame(admin);
        });

        setVisible(true);
    }
}