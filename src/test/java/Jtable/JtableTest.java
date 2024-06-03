package Jtable;

import javax.swing.*;
import java.awt.*;

public class JtableTest extends JFrame {
    public JtableTest() throws HeadlessException {
        super("测试jtable");

        setSize(600,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

    }

    public static void main(String[] args) {
        new JtableTest();

    }
}
