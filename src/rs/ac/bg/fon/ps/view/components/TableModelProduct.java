/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.view.components;

import java.math.BigDecimal;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import rs.ac.bg.fon.ps.domain.Distributor;
import rs.ac.bg.fon.ps.domain.Product;

/**
 *
 * @author Aleksandra
 */
public class TableModelProduct extends AbstractTableModel{

    private List<Product> products;
    private String[] columnNames=new String[]{ "Naziv", "Cena","Opis", "Distributer"};
    private Class[] columnClass=new Class[]{String.class, BigDecimal.class, String.class, Distributor.class};
    
    public TableModelProduct(List<Product> products){
        this.products=products;
    }
    
    @Override
    public int getRowCount() {
        if(products==null){
            return 0;
        }else{
            return products.size();
        }
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        if(column>columnNames.length){
            return "n/a";
        }else{
            return columnNames[column];
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex>columnClass.length){
            return Object.class;
        }else{
            return columnClass[columnIndex];
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Product product=products.get(rowIndex);
        switch(columnIndex){
            case 0:
                return product.getName();
            case 1: 
                return product.getPrice();
            case 2: 
                return product.getDescription();
            case 3: 
                return product.getDistributor();
            default:
                    return "n/a";
        }
    }

    
    public void addProduct(Product product){
        this.products.add(product);
        fireTableRowsInserted(products.size()-1, products.size()-1);
    }
    
    public void removeProduct(int row){
        products.remove(row);
        fireTableDataChanged();
    }
    
    public List<Product> getProducts(){
        return products;
    }
     public Product getProduct(int row){
        return products.get(row);
    }
}
