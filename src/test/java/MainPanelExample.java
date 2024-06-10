import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;


public class MainPanelExample {
    public static void main(String[] args) {
        // 创建主 JFrame
        JFrame frame = new JFrame("Main Panel Example");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 创建主 JPanel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // 创建一个子 JPanel
        JPanel subPanel = new JPanel();
        JLabel label = new JLabel("This is a sub panel");
        subPanel.add(label);

        // 将子 JPanel 添加到主 JPanel 中
        mainPanel.add(subPanel, BorderLayout.CENTER);

        // 将主 JPanel 添加到 JFrame 中
        frame.add(mainPanel);

        // 设置 JFrame 可见
        frame.setVisible(true);
    }
}
