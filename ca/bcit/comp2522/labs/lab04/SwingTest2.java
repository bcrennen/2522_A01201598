package ca.bcit.comp2522.labs.lab04;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingTest2 extends JFrame {

    private JButton buttonOne;
    private JButton buttonTwo;
    private JButton buttonThree;

    public SwingTest2() {
        super("Swing Test 2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buttonOne = new JButton("Press Me");
        buttonTwo = new JButton("Don't press me!");
        buttonThree = new JButton("Dunno, You Pick");
        getContentPane().setLayout(new FlowLayout());
        MyButtonListener listener = new MyButtonListener();
        getContentPane().add(buttonOne);
        getContentPane().add(buttonTwo);
        getContentPane().add(buttonThree);
        buttonOne.addActionListener(listener);
        buttonTwo.addActionListener(listener);
        buttonThree.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.out.println("Whoa ... Ugh?");
            }
        });
        setSize(320, 320);
        setVisible(true);
    }

    class MyButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //System.out.println("Thank you!");
            if (e.getSource() == buttonOne) {
                System.out.println("Thank you!");
            } else if (e.getSource() == buttonTwo) {
                System.out.println("What did I just tell you?!");
            }
        }
    }

    class TestPanel extends JPanel {

        private Color textColor = new Color(0, 0, 0);

        public TestPanel() {
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(textColor);
            g.drawString("Hello", 10, 10);
        }
    }

    public static void main(String[] args) {
        SwingTest2 test = new SwingTest2();
    }
}
