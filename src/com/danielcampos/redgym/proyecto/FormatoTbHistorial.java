
package com.danielcampos.redgym.proyecto;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class FormatoTbHistorial extends DefaultTableCellRenderer{
   
    public Component getTableCellRendererComponent
    
  (JTable table,Object value, boolean selected,boolean focused, int row,int column)  
  {
  if(String.valueOf(table.getValueAt(row, 0)).equals("ENTRADA")){
  Color verde = new Color(191,255,207);
  setBackground(verde);
  }
   if(String.valueOf(table.getValueAt(row, 0)).equals("SALIDA")){
  Color rojo = new Color(255,202,202);
  setBackground(rojo);
  }    
   super.getTableCellRendererComponent(table, value, selected, focused, row, column);
  return this;
  }    
    
}
