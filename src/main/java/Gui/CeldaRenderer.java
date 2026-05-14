/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gui;

import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Octav
 */
public class CeldaRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(
            JTable table,
            Object value,
            boolean isSelected,
            boolean hasFocus,
            int row,
            int column) {

        JLabel label = new JLabel();

        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);

        if (value instanceof Celda celda) {

            label.setText(celda.nombre);

            if (celda.imagen != null) {
                label.setIcon(celda.imagen);
            }

        } else {

            label.setText("");
            label.setIcon(null);
        }

        if (isSelected) {
            label.setBackground(Color.gray);
            label.setOpaque(true);
        }

        return label;
    }
}