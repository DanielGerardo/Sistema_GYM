/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielcampos.redgym.proyecto;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ColorCelda extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable Table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
      JLabel cell = (JLabel) super.getTableCellRendererComponent(Table, value, isSelected, hasFocus, row, column);
    if(value instanceof Object) {
      if(column==3){
          int valor=Integer.parseInt(String.valueOf(value));
          if(valor<=10){
              cell.setBackground(new Color(255,51,51));
              cell.setForeground(Color.white);
          }else{
              cell.setBackground(new Color(255, 255, 208));
              cell.setForeground(Color.black);
              
      }
          }else{
              cell.setBackground(new Color(255, 255, 208));
              cell.setForeground(Color.black);
              
      }
      }
     return  cell;
     }
}
