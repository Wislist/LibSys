package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import static sun.jvm.hotspot.oops.CellTypeState.top;

public class MyQQ_Frame extends JFrame {
    int x,y;

    public MyQQ_Frame() {
        //设置窗体大小
        setSize(425,330);
        //去除标题栏
        setUndecorated(true);
        //设置可见性
        setVisible(true);
        //设置透明度
        //

        //静态鼠标触发器
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e){
//				System.out.println("鼠标按下");
                //当鼠标点击时获取距离屏幕的坐标
                x=e.getX();
                y=e.getY();
            }
        });
        //动态鼠标触发器
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                int left = getLocation().x;
                int top = getLocation().y;

                setLocation(left + e.getX() - x, top + e.getY() - y);
            }
        });







    }








}
