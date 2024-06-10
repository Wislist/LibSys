package Jtable;

import lombok.Getter;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.Vector;

public class JtableDemo extends JFrame {
    public JtableDemo() throws HeadlessException {
        super("测试");



        Vector<Vector<Object>> data = new Vector<>();


        Vector<Object> rowVector1 = new Vector<>();

        rowVector1.addElement("1");
        rowVector1.addElement("张三");
        rowVector1.addElement("20000");
        rowVector1.addElement("220");


        Vector<Object> rowVector2 = new Vector<>();

        rowVector2.addElement("2");
        rowVector2.addElement("张三");
        rowVector2.addElement("20001");
        rowVector2.addElement("221");

        data.addElement(rowVector1);
        data.addElement(rowVector2);


        //tablemodel 和jtable关联后,之后只需要更新model就能把数据变化反应到jtable中
        StudentTableModel studentTableModel = StudentTableModel.assemBleModel(data);
        //jtable和table关联
        JTable jTable = new JTable(studentTableModel);
        //jTable默认放在Jscrollpane上否则不展示列头
        Container container = getContentPane();
        JScrollPane jScrollPane = new JScrollPane(jTable);
        container.add(jScrollPane);

        //设置表头
        jTable.setFont(new Font(null,Font.PLAIN,14));
        jTable.setForeground(Color.black);
        jTable.setGridColor(Color.black);
        jTable.setRowHeight(30);
        //设置多行选择
        jTable.getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        //设置表格列的渲染方式
        Vector<String> columns = StudentTableModel.getColumns();
        StudentCellRender render = new StudentCellRender();
        for (int i=0;i<columns.size();i++){
            TableColumn column = jTable.getColumn(columns.get(i));
            column.setCellRenderer(render);
            if(i == 0){
                column.setPreferredWidth(50);
                column.setMaxWidth(50);
                column.setResizable(false);
            } else {

            }

        }




        setSize(600,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);



    }

    public static void main(String[] args) {
        new JtableDemo();
    }
}


class StudentCellRender extends DefaultTableCellRenderer {

    //在每一行每一列显示之前
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if(row%2 == 0){
            setBackground(Color.LIGHT_GRAY);
        } else {
            setBackground(Color.white);
        }
        setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
}

//自定义DefaultTableModel
class StudentTableModel extends DefaultTableModel {

    @Getter
    static Vector<String> columns = new Vector<>();

    static {
        columns.addElement("学号");
        columns.addElement("姓名");
        columns.addElement("专业");
        columns.addElement("专业班级");
        columns.addElement("学号");
        columns.addElement("楼号");
        columns.addElement("宿舍号");
        columns.addElement("是否在宿舍");
    }

    private StudentTableModel() {
        super(null,columns);
    }
    private static StudentTableModel studentTableModel = new StudentTableModel();

    static StudentTableModel assemBleModel(Vector<Vector<Object>> data){
        studentTableModel.setDataVector(data,columns);
        return studentTableModel;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}