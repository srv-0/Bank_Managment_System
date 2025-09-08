package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import com.toedter.calendar.JDateChooser;

public class SignUp1 extends JFrame implements ActionListener {
    JTextField nameTextField, fnameTextField, emailTextField, addressTextField, stateTextField, pincodeTextField, cityTextField;
    JButton next;
    JLabel formNo, personDetails, name, fname, dob, gender, email, martial, state, pincode, city, address;
    JRadioButton malebtn, femalebtn, married, unmarried;
    JDateChooser dateChooser;

    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;
    String first = "" + Math.abs(first4);

    SignUp1() {

        setLayout(null); // Set layout before adding components

        formNo = new JLabel("APPLICATION FORM NO. " + first);
        formNo.setFont(new Font("Raleway", Font.BOLD, 38));
        formNo.setBounds(150, 20, 600, 40);
        add(formNo);

        personDetails = new JLabel("Page I: Personal Details ");
        personDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personDetails.setBounds(290, 80, 400, 30);
        add(personDetails);

        name = new JLabel("Name :");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);

        fname = new JLabel("Father's Name :");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameTextField.setBounds(300, 190, 400, 30);
        add(fnameTextField);

        dob = new JLabel("Date of Birth :");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 30);
        dateChooser.setForeground(Color.black);
        add(dateChooser);
        add(dateChooser);

        gender = new JLabel("Gender :");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 100, 30);
        add(gender);

        malebtn = new JRadioButton("Male");
        malebtn.setBounds(300, 290, 60, 30);
        malebtn.setBackground(Color.WHITE);
        add(malebtn);

        femalebtn = new JRadioButton("Female");
        femalebtn.setBounds(450, 290, 120, 30);
        femalebtn.setBackground(Color.WHITE);
        add(femalebtn);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(femalebtn);
        genderGroup.add(malebtn);

        email = new JLabel("Email :");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 340, 100, 30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTextField.setBounds(300, 340, 400, 30);
        add(emailTextField);

        martial = new JLabel("Martial Status :");
        martial.setFont(new Font("Raleway", Font.BOLD, 20));
        martial.setBounds(100, 390, 200, 30);
        add(martial);

        married = new JRadioButton("Married");
        married.setBounds(300, 390, 100, 30);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 390, 120, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        ButtonGroup martialGroup = new ButtonGroup();
        martialGroup.add(married);
        martialGroup.add(unmarried);

        address = new JLabel("Address :");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 100, 30);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        addressTextField.setBounds(300, 440, 400, 30);
        add(addressTextField);

        city = new JLabel("City :");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 100, 30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTextField.setBounds(300, 490, 400, 30);
        add(cityTextField);

        state = new JLabel("State :");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 100, 30);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        stateTextField.setBounds(300, 540, 400, 30);
        add(stateTextField);

        pincode = new JLabel("Pin Code :");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 590, 100, 30);
        add(pincode);

        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pincodeTextField.setBounds(300, 590, 400, 30);
        add(pincodeTextField);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
        setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formNo = first;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = malebtn.isSelected() ? "Male" : femalebtn.isSelected() ? "Female" : "";
        String email = emailTextField.getText();
        String martialStatus = married.isSelected() ? "Married" : unmarried.isSelected() ? "Unmarried" : "";
        String state = stateTextField.getText();
        String pincode = pincodeTextField.getText();
        String city = cityTextField.getText();
        String address = addressTextField.getText();

        try {
                if (name.equals("")) {
                    JOptionPane.showMessageDialog(null, "Name is Required");
                } else {
                    Conn c = new Conn();
                    String query = "INSERT INTO signup VALUES('" + formNo + "','" + name + "','" + fname + "','" + dob
                            + "','" + gender + "','" + email + "','" + martialStatus + "','" + state + "','" + pincode
                            + "','" + city + "','" + address + "')";
                    c.s.executeUpdate(query);
                    new Signup2(formNo).setVisible(true);
                    setVisible(false);
                }
            }
        catch (Exception E) {
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SignUp1();
    }
}
