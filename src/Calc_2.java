package Ampm_Calc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Calc_2 {
    JFrame frame;
    JPanel panel;
    JLabel result;
    String total = "";
    String current = "";
    String a = "";
    String b = "";
    int CalCase = 0;
    JButton btn_num1;
    JButton btn_num2;
    JButton btn_num3;
    JButton btn_num4;
    JButton btn_num5;
    JButton btn_num6;
    JButton btn_num7;
    JButton btn_num8;
    JButton btn_num9;
    JButton btn_num0;
    JButton btn_plus;
    JButton btn_minus;
    JButton btn_mul;
    JButton btn_div;
    JButton btn_equal;
    JButton btn_reset;
    boolean operatorPressed = false;

    public void setButton() {
        frame = new JFrame();
        panel = new JPanel();
        btn_num1 = new JButton("1");
        btn_num2 = new JButton("2");
        btn_num3 = new JButton("3");
        btn_num4 = new JButton("4");
        btn_num5 = new JButton("5");
        btn_num6 = new JButton("6");
        btn_num7 = new JButton("7");
        btn_num8 = new JButton("8");
        btn_num9 = new JButton("9");
        btn_num0 = new JButton("0");

        btn_plus = new JButton("+");
        btn_minus = new JButton("-");
        btn_mul = new JButton("*");
        btn_div = new JButton("/");

        btn_equal = new JButton("=");

        btn_reset = new JButton("AC");

        result = new JLabel("0", JLabel.RIGHT);
        panel.setLayout(null);
    }

    public void addButton() {
        panel.add(result);
        panel.add(btn_plus);
        panel.add(btn_minus);
        panel.add(btn_mul);
        panel.add(btn_div);
        panel.add(btn_num1);
        panel.add(btn_num2);
        panel.add(btn_num3);
        panel.add(btn_num4);
        panel.add(btn_num5);
        panel.add(btn_num6);
        panel.add(btn_num7);
        panel.add(btn_num8);
        panel.add(btn_num9);
        panel.add(btn_num0);
        panel.add(btn_equal);
        panel.add(btn_reset);
    }

    public void sizeButton() {
        result.setBounds(50, 50, 230, 50);
        btn_plus.setBounds(50, 110, 50, 50);
        btn_minus.setBounds(110, 110, 50, 50);
        btn_mul.setBounds(170, 110, 50, 50);
        btn_div.setBounds(230, 110, 50, 50);
        btn_num1.setBounds(50, 170, 50, 50);
        btn_num2.setBounds(110, 170, 50, 50);
        btn_num3.setBounds(170, 170, 50, 50);
        btn_num4.setBounds(50, 230, 50, 50);
        btn_num5.setBounds(110, 230, 50, 50);
        btn_num6.setBounds(170, 230, 50, 50);
        btn_num7.setBounds(50, 290, 50, 50);
        btn_num8.setBounds(110, 290, 50, 50);
        btn_num9.setBounds(170, 290, 50, 50);
        btn_num0.setBounds(50, 350, 170, 50);
        btn_equal.setBounds(230, 170, 50, 110);
        btn_reset.setBounds(230, 290, 50, 110);
    }

    public void actionListener() {
        variousOperator operator = new variousOperator();

        btn_num1.addActionListener(operator::Calculate);
        btn_num2.addActionListener(operator::Calculate);
        btn_num3.addActionListener(operator::Calculate);
        btn_num4.addActionListener(operator::Calculate);
        btn_num5.addActionListener(operator::Calculate);
        btn_num6.addActionListener(operator::Calculate);
        btn_num7.addActionListener(operator::Calculate);
        btn_num8.addActionListener(operator::Calculate);
        btn_num9.addActionListener(operator::Calculate);
        btn_num0.addActionListener(operator::Calculate);

        btn_plus.addActionListener(operator::Arithmetic);
        btn_minus.addActionListener(operator::Arithmetic);
        btn_mul.addActionListener(operator::Arithmetic);
        btn_div.addActionListener(operator::Arithmetic);

        btn_equal.addActionListener(operator::equal);
        btn_reset.addActionListener(operator::allClear);

        frame.add(panel);
        frame.setSize(350, 500);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Calc_2 cal = new Calc_2();
        cal.setButton();
        cal.addButton();
        cal.sizeButton();
        cal.actionListener();
    }

    class variousOperator implements ActionListener {
        public void Calculate(ActionEvent e) {
            JButton btn = (JButton) e.getSource();
            current += btn.getText();
            result.setText(current);
        }

        public void Arithmetic(ActionEvent e) {
            JButton btn = (JButton) e.getSource();
            if (!operatorPressed) {
                a = current;
                current = "";
                operatorPressed = true;
            }
            if (btn.getText().equals("+"))
                CalCase = 1;
            else if (btn.getText().equals("-"))
                CalCase = 2;
            else if (btn.getText().equals("*"))
                CalCase = 3;
            else if (btn.getText().equals("/"))
                CalCase = 4;
        }

        public void equal(ActionEvent e) {
            b = current;
            try {
                int num1 = Integer.parseInt(a);
                int num2 = Integer.parseInt(b);
                switch (CalCase) {
                    case 1:
                        total = Integer.toString(num1 + num2);
                        break;
                    case 2:
                        total = Integer.toString(num1 - num2);
                        break;
                    case 3:
                        total = Integer.toString(num1 * num2);
                        break;
                    case 4:
                        if (num2 == 0) {
                            total = "Error";
                        } else {
                            total = Integer.toString(num1 / num2);
                        }
                        break;
                }
            } catch (NumberFormatException ex) {
                total = "Error";
            }
            result.setText(total);
            current = total;
            operatorPressed = false;
        }

        public void actionPerformed(ActionEvent e) {

        }
        public void allClear(ActionEvent e) {
            a = "";
            b = "";
            CalCase = 0;
            total = "";
            current = "";
            result.setText("0");
            operatorPressed = false;
        }
    }
}
