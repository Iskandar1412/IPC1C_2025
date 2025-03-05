package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Log extends JFrame {
    private JButton button1;
    private JPanel PanelLog;
    private JTextField textField1;
    private JTextField textField2;

    public Log() {
        setContentPane(PanelLog);
        setTitle("Log");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Log.this, "Usuario: " + textField1.getText() + " Pass: " + textField2.getText());
            }
        });
    }
}
