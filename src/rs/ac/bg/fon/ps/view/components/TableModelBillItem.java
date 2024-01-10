/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.view.components;


import static com.sun.javafx.fxml.expression.Expression.add;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import rs.ac.bg.fon.ps.domain.BillItem;
import rs.ac.bg.fon.ps.domain.Status;


/**
 *
 * @author Aleksandra
 */
public class TableModelBillItem extends AbstractTableModel {

    private ArrayList<BillItem> stavke;
    private ArrayList<BillItem> obrisaneStavke;
    private String[] columns = {"Redni broj", "Naziv kozmetickog proizvoda", "Kolicina", "Cena"};

    public TableModelBillItem(ArrayList<BillItem> listaProizvoda) {
        this.stavke = listaProizvoda;
        obrisaneStavke = new ArrayList<>();
    }
   
    @Override
    public int getRowCount() {
        if (stavke == null) {
            return 0;
        }
        return stavke.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        BillItem b = stavke.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return ++rowIndex;
            case 1:
                return b.getProduct().getName();
            case 2:
                return b.getQuantity();
            case 3:
                return b.getPrice();
            default:
                return null;
        }
    }


    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    public BillItem getBillItem(int row) {
        return stavke.get(row);
    }

    public void addBillItem(BillItem bi) {
        long max = 0;
        for (BillItem b : stavke) {
            if (b.getBillItemID() > max) {
                max = b.getBillItemID();
            }
        }
        bi.setBillItemID(max + 1);
        for (BillItem x : stavke) {
            if (x.getProduct().equals(bi.getProduct())) {
                x.setQuantity(bi.getQuantity() + x.getQuantity());
                double price=bi.getPrice().doubleValue()+x.getPrice().doubleValue();
                x.setPrice(new BigDecimal(price));
                fireTableDataChanged();
                return;
                
            
            }
        }
        stavke.add(bi);
        fireTableDataChanged();
    }
    


    public ArrayList<BillItem> getBillItemList() {
        return stavke;
    }

    public void setBillItemList(ArrayList<BillItem> stavke) {
        this.stavke = stavke;
        fireTableDataChanged();
    }

    public void delete(int row) {
        BillItem bi = stavke.remove(row);
        if (!bi.getStatus().equals(Status.NEW)) {
            bi.setStatus(Status.DELETE);
            obrisaneStavke.add(bi);
        }
        fireTableDataChanged();
    }

    public void update(BillItem bi, int row) {
        stavke.remove(row);
        stavke.add(bi);
        fireTableDataChanged();
    }

    public ArrayList<BillItem> getAllBillItems() {
        obrisaneStavke.addAll(stavke);
        return obrisaneStavke;
    }

    
    public void refresh(){
        fireTableDataChanged();
    }
   
  
}
