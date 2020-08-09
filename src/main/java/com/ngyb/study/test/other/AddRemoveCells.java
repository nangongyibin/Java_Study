package com.ngyb.study.test.other;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

public class AddRemoveCells implements ActionListener {

    private final DefaultTableModel model;
    private final JTable table;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("增加列")) {
            model.addColumn("增加列");
        }
        if (e.getActionCommand().equals("增加行")) {
            model.addRow(new Vector());
        }
        if (e.getActionCommand().equals("删除列")) {
            int columnCount = model.getColumnCount() - 1;
            if (columnCount >=0){
                TableColumnModel columnModel = table.getColumnModel();
                TableColumn tableColumn = columnModel.getColumn(columnCount);
                columnModel.removeColumn(tableColumn);
                model.setColumnCount(columnCount);
            }
        }
        if (e.getActionCommand().equals("删除行")) {
            int rowCount = model.getRowCount() - 1;
            if (rowCount >=0){
                model.removeRow(rowCount);
                model.setRowCount(rowCount);
            }
        }
    }

    public AddRemoveCells() {
        JFrame f = new JFrame();
        String[] name = {"字段1", "字段2", "字段3", "字段4", "字段5"};
        String[][] data = new String[5][5];
        int value = 1;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = String.valueOf(value++);
            }
        }
        model = new DefaultTableModel(data, name);
        table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(400, 80));
        JScrollPane s = new JScrollPane(table);
        JPanel panel = new JPanel();
        JButton b = new JButton("增加行");
        panel.add(b);
        b.addActionListener(this);
        b = new JButton("增加列");
        panel.add(b);
        b.addActionListener(this);
        b = new JButton("删除行");
        panel.add(b);
        b.addActionListener(this);
        b = new JButton("删除列");
        panel.add(b);
        b.addActionListener(this);
        Container contentPane = f.getContentPane();
        contentPane.add(panel, BorderLayout.NORTH);
        contentPane.add(s, BorderLayout.CENTER);
        f.setTitle("AddRemoveCells ");
        f.pack();
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
//                super.windowClosing(e);
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new AddRemoveCells();
    }
}
