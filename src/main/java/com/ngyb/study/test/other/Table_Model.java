package com.ngyb.study.test.other;

import javax.swing.table.AbstractTableModel;
import java.util.Vector;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/8/9 15:27
 */
public class Table_Model extends AbstractTableModel {
    public static final long serialVersionUID = -3094977414157589758l;
    private Vector content = null;
    public String[] title_name = {"姓名", "性别", "年龄"};

    public Table_Model() {
        content = new Vector();
    }

    public Table_Model(int count) {
        content = new Vector(count);
    }

    /**
     * 加入一空行
     *
     * @param row 行号
     */
    public void addRow(int row) {
        Vector v = new Vector(3);
        v.add(0, null);
        v.add(1, null);
        v.add(2, null);
        content.add(row, v);
    }

    /**
     * 加入一行内容
     *
     * @param name
     * @param is
     * @param age
     */
    public void addRow(String name, boolean is, String age) {
        Vector v = new Vector(3);
        v.add(0, name);
        v.add(1, new Boolean(is));//JCheckBox是Boolean的默认显示组件，这里仅仅为了看小姑，
        v.add(2, age);//本列在前面已经设置成了JComboBox组件，这里随便输入什么字符串都没关系
        content.add(v);
    }

    public void removeRow(int row) {
        content.remove(row);
    }

    /**
     * 某些行某些列不可编辑
     *
     * @param rowIndex
     * @param columnIndex
     * @return
     */
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (rowIndex == 2) {
            return false;
        }
        return true;
    }

    public void setValueAt(Object value, int row, int col) {
        ((Vector) content.get(row)).remove(col);
        ((Vector) content.get(row)).add(col, value);
        this.fireTableCellUpdated(row, col);
    }

    public String getColumnName(int col) {
        return title_name[col];
    }

    @Override
    public int getRowCount() {
        return content.size();
    }

    @Override
    public int getColumnCount() {
        return title_name.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return ((Vector) content.get(rowIndex)).get(columnIndex);
    }

    public Class getColumnClass(int col) {
        return getValueAt(0, col).getClass();
    }
}
