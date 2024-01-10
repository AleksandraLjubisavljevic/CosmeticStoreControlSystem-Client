/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.view.form;

import java.math.BigDecimal;
import java.util.List;
import rs.ac.bg.fon.ps.domain.Status;
import javax.swing.JOptionPane;
import rs.ac.bg.fon.ps.controller.Controller;
import rs.ac.bg.fon.ps.domain.BillItem;
import rs.ac.bg.fon.ps.domain.Product;
import rs.ac.bg.fon.ps.validation.ValidationForms;
import rs.ac.bg.fon.ps.view.components.TableModelBillItem;
import rs.ac.bg.fon.ps.view.components.TableModelProduct;

/**
 *
 * @author Aleksandra
 */
public class FrmSaveBillItem extends javax.swing.JFrame {

    TableModelBillItem tmbi;
    BillItem bi;
    int selectedRow;
    
    /**
     * Creates new form FrmSaveBillItem
     */
    public FrmSaveBillItem() throws Exception {
        initComponents();
        this.setTitle("Stavka racuna");
        this.setLocationRelativeTo(null);
        prepareView();
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        btnEdit.setVisible(false);
        Product p = (Product) jcbProducts.getSelectedItem();
        jlbPrice.setText(p.getPrice()+"");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlbProduct = new javax.swing.JLabel();
        jcbProducts = new javax.swing.JComboBox();
        jlbPrice1 = new javax.swing.JLabel();
        jlbPrice = new javax.swing.JLabel();
        jlbQuantity = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        jlbFinal = new javax.swing.JLabel();
        jlbFinalPrice = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jlbError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Stavka racuna"));

        jlbProduct.setText("Proizvod");

        jcbProducts.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbProducts.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbProductsItemStateChanged(evt);
            }
        });

        jlbPrice1.setText("Cena");

        jlbPrice.setText("0");

        jlbQuantity.setText("Kolicina");

        txtQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQuantityKeyReleased(evt);
            }
        });

        jlbFinal.setText("Ukupni iznos");

        jlbFinalPrice.setText("0");

        btnSave.setText("Sacuvaj");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnEdit.setText("Izmeni");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        jlbError.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbError.setForeground(new java.awt.Color(255, 0, 51));
        jlbError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jlbFinal)
                                .addComponent(jlbPrice1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jlbQuantity, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jlbProduct, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jcbProducts, 0, 212, Short.MAX_VALUE)
                                    .addComponent(jlbPrice)
                                    .addComponent(txtQuantity))
                                .addComponent(jlbFinalPrice)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(9, 9, 9)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jlbError, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbProduct)
                    .addComponent(jcbProducts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbPrice1)
                    .addComponent(jlbPrice))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbQuantity)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbFinal)
                    .addComponent(jlbFinalPrice))
                .addGap(18, 18, 18)
                .addComponent(jlbError, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnEdit)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        jlbError.setText("");
        if (!ValidationForms.getInstance().validateEmpty(txtQuantity)) {
            jlbError.setText(ValidationForms.getInstance().getValidationMessage());
            return;
        }
        
        Product p = (Product) jcbProducts.getSelectedItem();
        
        double cena = Double.parseDouble(jlbFinalPrice.getText());
        
        try{
        int kolicina = Integer.parseInt(txtQuantity.getText());
        
        if(kolicina<0){
            JOptionPane.showMessageDialog(this, "Kolicina mora biti pozitivan broj");
            return;
        }
        
        BillItem bi = new BillItem(null, 0l, new BigDecimal(cena), kolicina,p, Status.NEW);
        
        tmbi.addBillItem(bi);
       
        
        dispose();
        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Kolicina mora biti ceo broj");
        }
        
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        Product p = (Product) jcbProducts.getSelectedItem();
        
        double cena = Double.parseDouble(jlbFinalPrice.getText());
        try{
        int kolicina = Integer.parseInt(txtQuantity.getText());
        
        if(kolicina<0){
            JOptionPane.showMessageDialog(this, "Kolicina mora biti pozitivan broj");
            return;
        }
            
        String status = bi.getStatus()==Status.NEW ? Status.NEW : Status.UPDATE;
        
            
        BillItem bii = new BillItem(bi.getBill(), bi.getBillItemID(), new BigDecimal(cena), kolicina, p, status);
           
        tmbi.update(bii,selectedRow);
        dispose();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Kolicina mora biti ceo broj");
        }
        
    }//GEN-LAST:event_btnEditActionPerformed

    private void jcbProductsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbProductsItemStateChanged
        // TODO add your handling code here:
        Product p = (Product) jcbProducts.getSelectedItem();
        if(p!=null)
            jlbPrice.setText(p.getPrice()+"");
        
        if (!txtQuantity.getText().isEmpty()) {
            String quantity = txtQuantity.getText();
            try{
            int kolicina = Integer.parseInt(quantity);
            if(kolicina<0){
                JOptionPane.showMessageDialog(this, "Kolicina mora biti pozitivan broj");
                return;
            }
            jlbFinalPrice.setText(kolicina*p.getPrice().intValue()+"");
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this, "Kolicina mora biti ceo broj!");
            }
        }
        
    }//GEN-LAST:event_jcbProductsItemStateChanged

    private void txtQuantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantityKeyReleased
        // TODO add your handling code here:
         Product p = (Product) jcbProducts.getSelectedItem();
        
        
        if (!txtQuantity.getText().isEmpty()) {
            String quantity = txtQuantity.getText();
            try{
            int kolicina = Integer.parseInt(quantity);
            if(kolicina<0){
                JOptionPane.showMessageDialog(this, "Kolicina mora biti pozitivan broj");
                return;
            }
            jlbFinalPrice.setText(kolicina*p.getPrice().intValue()+"");
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this, "Kolicina mora biti ceo broj!");
            }
        }
        
    }//GEN-LAST:event_txtQuantityKeyReleased
   
    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSave;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox jcbProducts;
    private javax.swing.JLabel jlbError;
    private javax.swing.JLabel jlbFinal;
    private javax.swing.JLabel jlbFinalPrice;
    private javax.swing.JLabel jlbPrice;
    private javax.swing.JLabel jlbPrice1;
    private javax.swing.JLabel jlbProduct;
    private javax.swing.JLabel jlbQuantity;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables

    private void prepareView() throws Exception {
        List<Product> list = Controller.getInstance().getProducts(null);

        jcbProducts.removeAllItems();

        for (Product p : list) {
            jcbProducts.addItem(p);
        }
    }
    void setMtp(TableModelBillItem tmbi) {
        this.tmbi = tmbi;
    }
    void fillForm(BillItem bi, int row) {
        btnEdit.setVisible(true);
        btnSave.setVisible(false);
        jcbProducts.setSelectedItem(bi.getProduct());
        this.bi = bi;
        selectedRow=row;
    }
}
