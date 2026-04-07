import javax.swing.*;

class StudentFrame extends JFrame {

    public StudentFrame(Admin admin) {

        setTitle("Student Login");
        setSize(300, 250);
        setLayout(null);

        JLabel seatLabel = new JLabel("Seat No:");
        seatLabel.setBounds(30, 30, 80, 25);
        add(seatLabel);

        JTextField seatField = new JTextField();
        seatField.setBounds(120, 30, 130, 25);
        add(seatField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(30, 70, 80, 25);
        add(passLabel);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(120, 70, 130, 25);
        add(passField);

        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(80, 120, 120, 30);
        add(loginBtn);

        loginBtn.addActionListener(e -> {
            try {
                int seat = Integer.parseInt(seatField.getText());
                String pass = passField.getText();

                Student s = admin.findStudent(seat, pass);

                if (s != null) {
                    JOptionPane.showMessageDialog(this, s.getResultText());
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid Credentials");
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid Input!");
            }
        });

        setVisible(true);
    }
}