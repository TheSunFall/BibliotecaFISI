package com.BibliotecaFISI;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

class ButtonColumn extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
    protected JButton renderButton;
    protected JButton editButton;
    private String text;
    private ActionListener actionListener;

    public ButtonColumn(JTable table, ActionListener actionListener, int column) {
        this.actionListener = actionListener;
        renderButton = new JButton();
        editButton = new JButton();
        
        editButton.addActionListener(actionListener);
        table.getColumnModel().getColumn(column).setCellRenderer(this);
        table.getColumnModel().getColumn(column).setCellEditor(this);
    }

    public Object getCellEditorValue() {
        return text;
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        text = (value == null) ? "" : value.toString();
        editButton.setText(text);
        return editButton;
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        text = (value == null) ? "" : value.toString();
        renderButton.setText(text);
        return renderButton;
    }
}
