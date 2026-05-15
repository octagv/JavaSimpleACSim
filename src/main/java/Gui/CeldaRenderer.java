/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gui;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;


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

        label.setOpaque(true);

        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);

        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.CENTER);

        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setForeground(Color.RED);

        if (value instanceof Celda celda) {

            label.setText(celda.nombre);

            if (celda.imagen != null) {

                int ancho = table.getColumnModel()
                        .getColumn(column)
                        .getWidth();

                int alto = table.getRowHeight(row);

                Image imagenEscalada = celda.imagen.getImage()
                        .getScaledInstance(
                                ancho,
                                alto,
                                Image.SCALE_SMOOTH
                        );

                label.setIcon(new ImageIcon(imagenEscalada));
            }

        } else {

            label.setText("");
            label.setIcon(null);
            label.setBackground(Color.WHITE);
        }

        if (isSelected) {
            label.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
        }

        return label;
    }
}