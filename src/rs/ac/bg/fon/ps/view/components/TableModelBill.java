/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.view.components;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import rs.ac.bg.fon.ps.domain.Bill;

/**
 *
 * @author Aleksandra
 */
public class TableModelBill extends AbstractTableModel{
     List<Bill> bills;
     String[] columns = {"ID racuna", "Datum","Cena","Izdat","Korisnik"};
    private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    public TableModelBill(List<Bill> bills) {
        this.bills = bills;
    }

    @Override
    public int getRowCount() {
        return bills.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Bill b = bills.get(rowIndex);
        switch(columnIndex) {
            case 0: return b.getBillID();
            case 1: return sdf.format(b.getDate());
            case 2: return b.getAmount();
            case 3: return b.isProcessed();
            case 4: return b.getUser().getFirstname() + " " + b.getUser().getLastname();
            default: return "n/a";
        }
    }


    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
    
    public Bill getBill(int row){
        return bills.get(row);
    }


/*
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            Bill b = bills.get(rowIndex);
            switch (columnIndex) {
                case 3: b.setProcessed(new Boolean(aValue.toString())); break;
                
            }
    }
  */

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex) {
            case 2: return BigDecimal.class;
            case 3: return Boolean.class;
            default: return Object.class;
        }
    }

 
 
    
}
   