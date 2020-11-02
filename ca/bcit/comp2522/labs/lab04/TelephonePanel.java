package ca.bcit.comp2522.labs.lab04;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TelephonePanel extends JPanel {

    private JButton[] numbers = new JButton[12];

    public TelephonePanel() {
        // set BorderLayout for this panel
        setLayout(new BorderLayout());

        // create a JLabel with "Your Telephone" title
        JPanel titlePanel = new JPanel();
        JLabel title = new JLabel("Your Telephone", JLabel.CENTER);

        // add title label to north of this panel
        titlePanel.add(title);
        add(titlePanel, BorderLayout.NORTH);

        // create panel to hold keypad and give it a 4x3 GridLayout
        JPanel numberPanel = new JPanel();
        add(numberPanel, BorderLayout.CENTER);
        numberPanel.setLayout(new GridLayout(4, 3));

        // add buttons representing keys to key panel
        // add key panel to center of this panel
        numbers[0] = new JButton("1");
        numbers[1] = new JButton("2");
        numbers[2] = new JButton("3");
        numbers[3] = new JButton("4");
        numbers[4] = new JButton("5");
        numbers[5] = new JButton("6");
        numbers[6] = new JButton("7");
        numbers[7] = new JButton("8");
        numbers[8] = new JButton("9");
        numbers[10] = new JButton("0");

        ButtonListener listener = new ButtonListener();
        numbers[0].addActionListener(listener);
        numbers[1].addActionListener(listener);
        numbers[2].addActionListener(listener);
        numbers[3].addActionListener(listener);
        numbers[4].addActionListener(listener);
        numbers[5].addActionListener(listener);
        numbers[6].addActionListener(listener);
        numbers[7].addActionListener(listener);
        numbers[8].addActionListener(listener);
        numbers[10].addActionListener(listener);

        // for * and # keys
        numbers[9] = new JButton("*");
        numbers[9].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("key pressed: *");
            }
        });
        numbers[11] = new JButton("#");
        numbers[11].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("key pressed: #");
            }
        });
        for (int i = 0; i < 12; i++) {
            numberPanel.add(numbers[i]);
        }
    }
    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == numbers[0]) {
                System.out.println("key pressed: " + 1);
            } else if (e.getSource() == numbers[1]) {
                System.out.println("key pressed: " + 2);
            } else if (e.getSource() == numbers[2]) {
                System.out.println("key pressed: " + 3);
            } else if (e.getSource() == numbers[3]) {
                System.out.println("key pressed: " + 4);
            } else if (e.getSource() == numbers[4]) {
                System.out.println("key pressed: " + 5);
            } else if (e.getSource() == numbers[5]) {
                System.out.println("key pressed: " + 6);
            } else if (e.getSource() == numbers[6]) {
                System.out.println("key pressed: " + 7);
            } else if (e.getSource() == numbers[7]) {
                System.out.println("key pressed: " + 8);
            } else if (e.getSource() == numbers[8]) {
                System.out.println("key pressed: " + 9);
            } else if (e.getSource() == numbers[10]) {
                System.out.println("key pressed: " + 0);
            }
        }
    }
}
