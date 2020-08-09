package com.ngyb.study.test.other;

import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.awt.*;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/8/9 15:24
 */
public class ZL {
    private JFrame frame = null;
    private JTable table = null;
    private Table_Model model = null;
    private JScrollPane pane = null;

    public ZL() {
        frame = new JFrame("Bean");
        model = new Table_Model(20);
        table = new JTable(model);
        String[] age = {"21", "22", "23", "24", "25", "26", "27", "28", "29", "30"};
        JComboBox com = new JComboBox(age);
        TableColumnModel tcm = table.getColumnModel();
        tcm.getColumn(2).setCellEditor(new DefaultCellEditor(com));//设置某列采用JComboBox组件
        model.addRow("宋江", true, "30");
        model.addRow("孙二娘", false, "21");
        model.addRow("武松", true, "24");
        pane = new JScrollPane(table);

        frame.getContentPane().add(pane, BorderLayout.CENTER);
        frame.setSize(300, 200);
        frame.setVisible(true);
        model.addRow(2);//在某处插入一空行
        table.updateUI();//刷新
    }

    public static void main(String[] args) {
        new ZL();
    }
}
