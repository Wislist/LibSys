package Views.StudentInterface;
/**
 * new PersonalView("001").setVisible(true); // 假设登录用户名为 "001" 后续需调整为登录之后的工号
 * 传参 工号
 */

import Views.StudentInterface.Connect.Personal_Connect;
import Views.StudentInterface.complain.complain;
import Views.StudentInterface.Man_view.View;
import Views.StudentInterface.Personal_View.PersonalView;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_view extends JFrame {
    String id;

    private String[] buttonTexts = {"个人信息查看", "通知处理", "学生信息管理", "退出"};

    public Main_view() {
        setTitle("宿舍管理主界面");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 20, 20));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        for (String text : buttonTexts) {
            JButton button = new JButton(text);
            button.setFont(new Font("微软雅黑", Font.BOLD, 16));
            button.setPreferredSize(new Dimension(150, 50));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // 获取按钮文本
                    String buttonText = ((JButton) e.getSource()).getText();

                    // 根据按钮文本执行不同的逻辑
                    switch (buttonText) {
                        case "个人信息查看":
                            // 打开个人信息界面

                            new PersonalView().setVisible(true); // 假设登录用户名为 "001" 后续需调整为登录之后的工号
                            break;
                        case "通知处理":
                            // 打开通知处理界面
                            // ... 创建通知处理界面 ...
                            // ... 设置界面可见 ...
                            new complain().setVisible(true);
                            break;
                        case "学生信息管理":
                            // 打开学生信息管理界面
                            new View().setVisible(true);
                            break;
                        case "退出":
                            // 退出程序
                            System.exit(0);
                            break;
                    }
                }
            });
            buttonPanel.add(button);
        }

        add(buttonPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main_view());
    }
}
