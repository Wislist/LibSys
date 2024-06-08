package Views.StudentInterface;

import javax.swing.*;
import java.awt.*;

public class dialog {
    public dialog(String st1,String st2){
        // 创建自定义对话框
        JFrame frame = new JFrame("提示框");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 400);
        // 使用FlowLayout布局管理器
        frame.setLayout(new FlowLayout());
        // 创建面板并添加组件
        JPanel panel = new JPanel();
        panel.add(new JLabel(st1));
        JButton closeButton = new JButton("关闭");
        closeButton.addActionListener(e -> frame.dispose());
        panel.add(closeButton);

        // 将面板添加到对话框中
        JDialog dialog = new JDialog(frame, st2, true);
        dialog.setSize(800,400);
        dialog.setContentPane(panel);
        dialog.pack();
        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true);
    }
}
