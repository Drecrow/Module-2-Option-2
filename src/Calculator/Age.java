package Calculator;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Age extends JFrame {
    private JPanel mainPanel;
    private JButton calculateButton;
    private JLabel ageLabel;
    private JTextField birthDateField;

    public Age() {
        setTitle("Age Calculator");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 1));

        birthDateField = new JTextField();
        mainPanel.add(new JLabel("Enter your birth date (YYYY-MM-DD):"));
        mainPanel.add(birthDateField);

        calculateButton = new JButton("Calculate Age");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateAge();
            }
        });
        mainPanel.add(calculateButton);

        ageLabel = new JLabel();
        mainPanel.add(ageLabel);

        add(mainPanel);
        setVisible(true);
    }

    private void calculateAge() {
        String birthDateString = birthDateField.getText();
        LocalDate birthDate = LocalDate.parse(birthDateString);

        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(birthDate, currentDate);

        int years = period.getYears();
        int months = period.getMonths();
        int days = period.getDays();

        String ageMessage = String.format("You are %d years, %d months, and %d days old.", years, months, days);
        ageLabel.setText(ageMessage);
    }

    public static void main(String[] args) {
        new Age();
    }
}
