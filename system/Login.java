package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JLabel WlcmTxt, CardTxt, PinTxt;
    JTextField textField2;
    JPasswordField passwordField3;

    JButton signInBtn, clearBtn, signUpBtn;

    Login() {
        super("Bank Management System");
        setLayout(null);
        

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 10, 100, 100);
        add(image);

        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
        Image ii2 = ii1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel iimage = new JLabel(ii3);
        iimage.setBounds(630, 350, 100, 100);
        add(iimage);

        WlcmTxt = new JLabel("WELCOME TO ATM");
        WlcmTxt.setForeground(Color.WHITE);
        WlcmTxt.setFont(new Font("AvantGarde", Font.BOLD, 38));
        WlcmTxt.setBounds(230, 125, 450, 40);
        add(WlcmTxt);

        CardTxt = new JLabel("Card No:");
        CardTxt.setFont(new Font("Ralway", Font.BOLD, 28));
        CardTxt.setForeground(Color.WHITE);
        CardTxt.setBounds(150, 190, 375, 30);
        add(CardTxt);

        textField2 = new JTextField(15);
        textField2.setBounds(325, 190, 230, 30);
        textField2.setFont(new Font("Arial", Font.BOLD, 14));
        add(textField2);

        PinTxt = new JLabel("PIN: ");
        PinTxt.setFont(new Font("Ralway", Font.BOLD, 28));
        PinTxt.setForeground(Color.WHITE);
        PinTxt.setBounds(150, 250, 375, 30);
        add(PinTxt);

        passwordField3 = new JPasswordField(15);
        passwordField3.setBounds(325, 250, 230, 30);
        passwordField3.setFont(new Font("Arial", Font.BOLD, 14));
        add(passwordField3);

        signInBtn = new JButton("SIGN IN");
        signInBtn.setFont(new Font("Arial", Font.BOLD, 14));
        signInBtn.setForeground(Color.WHITE);
        signInBtn.setBackground(Color.BLACK);
        signInBtn.setBounds(300, 300, 100, 30);
        signInBtn.addActionListener(this);
        add(signInBtn);

        clearBtn = new JButton("CLEAR");
        clearBtn.setFont(new Font("Arial", Font.BOLD, 14));
        clearBtn.setForeground(Color.WHITE);
        clearBtn.setBackground(Color.BLACK);
        clearBtn.setBounds(430, 300, 100, 30);
        clearBtn.addActionListener(this);
        add(clearBtn);

        signUpBtn = new JButton("SIGN UP");
        signUpBtn.setFont(new Font("Arial", Font.BOLD, 14));
        signUpBtn.setForeground(Color.WHITE);
        signUpBtn.setBackground(Color.BLACK);
        signUpBtn.setBounds(300, 350, 230, 30);
        signUpBtn.addActionListener(this);
        add(signUpBtn);

        ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("icon/backbg.png"));
        Image iii2 = iii1.getImage().getScaledInstance(850, 480, Image.SCALE_DEFAULT);
        ImageIcon iii3 = new ImageIcon(iii2);
        JLabel iiimage = new JLabel(iii3);
        iiimage.setBounds(0, 0, 850, 480);
        add(iiimage);

        setSize(850, 480);
        setLocation(450, 200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == signInBtn) {
                Conn c = new Conn();
                String cardno = textField2.getText();
                String pin = String.valueOf(passwordField3.getPassword());
                String q = "select * from login where CardNo = '" + cardno + "' and  Pin = '" + pin + "'";
                ResultSet resultSet = c.s.executeQuery(q);
                if (resultSet.next()) {
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            } else if (e.getSource() == clearBtn) {
                textField2.setText("");
                passwordField3.setText("");
            } else if (e.getSource() == signUpBtn) {
                setVisible(false);
                new SignUp1().setVisible(true);
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}