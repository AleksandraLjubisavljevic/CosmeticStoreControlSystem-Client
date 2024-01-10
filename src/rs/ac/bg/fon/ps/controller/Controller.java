/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import rs.ac.bg.fon.ps.client.communication.Communication;
import rs.ac.bg.fon.ps.communication.Operations;
import rs.ac.bg.fon.ps.communication.Request;
import rs.ac.bg.fon.ps.communication.Response;
import rs.ac.bg.fon.ps.communication.ResponseType;
import rs.ac.bg.fon.ps.domain.Bill;
import rs.ac.bg.fon.ps.domain.Distributor;
import rs.ac.bg.fon.ps.domain.Product;
import rs.ac.bg.fon.ps.domain.User;

/**
 *
 * @author Aleksandra
 */
public class Controller {
    private static Controller instance;
    private User currentUser;
    private Product currentProduct;
    private Bill currentBill;
    
    private Controller() {
    }

    public static Controller getInstance() {
        if(instance == null)
            instance = new Controller();
        return instance;
    }
  

    public void setCurrentUser(User user) {
        this.currentUser=user;
    }
    public User getCurrentUser() {
        return currentUser;
    }

    public List<Distributor> getAllDistributors() throws Exception {
        Distributor d=new Distributor(0l,null,null);
        Request request = new Request(Operations.GET_ALL_DISTRIBUTORS, d);
        Response response = Communication.getInstance().getAllDistributors(request);
        if (response.getResponseType().equals(ResponseType.SUCCESS)){
            List<Distributor> distributors=(List<Distributor>)response.getResult();
            return distributors;
            }else{
                 JOptionPane.showMessageDialog(null, response.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
                 return new ArrayList<>();
            }
    }

    public void addProduct(Product product) throws Exception {
        Request request = new Request(Operations.ADD_PRODUCT, product);
        Response response = Communication.getInstance().addProduct(request);
        if (response.getResponseType().equals(ResponseType.SUCCESS)){
            JOptionPane.showMessageDialog(null, response.getMessage(), "Uspesno", JOptionPane.INFORMATION_MESSAGE);
            }else{
                 JOptionPane.showMessageDialog(null,response.getMessage(), "Neuspesno", JOptionPane.ERROR_MESSAGE );
            }
       
    
    }
       public List<Product> getProducts(String filterText) throws Exception {
        Product p = new Product(0l, filterText, new BigDecimal(0), filterText, null);
        Request request = new Request(Operations.GET_ALL_PRODUCTS, p);
        Response response = Communication.getInstance().getProducts(request);
        
        if (response.getResponseType().equals(ResponseType.SUCCESS)){
            List<Product> products=(List<Product>)response.getResult();
            if(products.isEmpty()){
                JOptionPane.showMessageDialog(null,"Sistem ne moze da nadje kozmeticke proizvode po zadatom kriterijumu", "Neuspesno", JOptionPane.ERROR_MESSAGE );
            }
            return products;
            }else {
                  JOptionPane.showMessageDialog(null,response.getMessage(), "Neuspesno", JOptionPane.ERROR_MESSAGE );
                  return new ArrayList<>();
            }
        
    }  
       public boolean ucitajProizvod(Product p) throws Exception{
        
        Request request = new Request(Operations.UCITAJ_PROIZVOD,p);
        Response response=Communication.getInstance().ucitajProizvod(request);
        List<Product> listProducts = (List<Product>) response.getResult();
        JOptionPane.showMessageDialog(null, response.getMessage());
        if(listProducts == null || listProducts.isEmpty()){
            return false;
        }else{
            currentProduct = listProducts.get(0);
            return true;
        } 
    }
        public boolean ucitajRacun(Bill b) throws Exception{
        
        Request request = new Request(Operations.UCITAJ_RACUN,b);
        Response response=Communication.getInstance().ucitajRacun(request);
        List<Bill> listBills = (List<Bill>) response.getResult();
        JOptionPane.showMessageDialog(null, response.getMessage());
        if(listBills == null || listBills.isEmpty()){
            return false;
        }else{
            currentBill = listBills.get(0);
            return true;
        } 
    }
           
       

    public void updateProduct(Product product) throws Exception {
        Request request = new Request(Operations.UPDATE_PRODUCT, product);
        Response response = Communication.getInstance().updateProduct(request);
        if (response.getResponseType().equals(ResponseType.SUCCESS)){
             JOptionPane.showMessageDialog(null, response.getMessage(), "Uspesno", JOptionPane.INFORMATION_MESSAGE);
            }else{
                 JOptionPane.showMessageDialog(null, response.getMessage(), "Neuspesno", JOptionPane.ERROR_MESSAGE);
            }
    }
    
    public void deleteProduct(Product product) throws Exception {
        Request request = new Request(Operations.DELETE_PRODUCT, product);
        Response response = Communication.getInstance().deleteProduct(request);
        if (response.getResponseType().equals(ResponseType.SUCCESS)){
             JOptionPane.showMessageDialog(null, response.getMessage(), "Uspesno", JOptionPane.INFORMATION_MESSAGE);
            }else{
                 JOptionPane.showMessageDialog(null, response.getMessage(), "Neuspesno", JOptionPane.ERROR_MESSAGE);
            }
    }
    
     public void addBill(Bill bill) throws Exception {
        bill.setUser(currentUser);
        Request request = new Request(Operations.ADD_BILL, bill);
        Response response = Communication.getInstance().addBill(request);
        if (response.getResponseType().equals(ResponseType.SUCCESS)){
            JOptionPane.showMessageDialog(null, response.getMessage(), "Uspesno", JOptionPane.INFORMATION_MESSAGE);
            }else{
                 JOptionPane.showMessageDialog(null,response.getMessage(), "Neuspesno", JOptionPane.ERROR_MESSAGE );
            }
    }
  
     
    public List<Bill> getBills(String filterText) throws Exception {
        Long filter;
        if(!filterText.isEmpty()){
        filter=Long.parseLong(filterText);
        }else{
            filter=0l;
        }
        Bill bill=new Bill(filter, null, new BigDecimal(0), true, currentUser,null);
        Request request = new Request(Operations.GET_ALL_BILLS, bill);
        Response response = Communication.getInstance().getBills(request);
        
        if (response.getResponseType().equals(ResponseType.SUCCESS)){
            List<Bill> bills=(List<Bill>)response.getResult();
            return bills;
            }else{
                 JOptionPane.showMessageDialog(null,response.getMessage(), "Neuspesno", JOptionPane.ERROR_MESSAGE );
                 return new ArrayList<>();
            }
    
    }
     
    public void updateBill(Bill b) throws Exception {
        Request request = new Request(Operations.UPDATE_BILL, b);
        b.setUser(currentUser);
        Response response = Communication.getInstance().updateBill(request);
        if (response.getResponseType().equals(ResponseType.SUCCESS)){
          JOptionPane.showMessageDialog(null, response.getMessage(), "Uspesno", JOptionPane.INFORMATION_MESSAGE);
            }else{
                 JOptionPane.showMessageDialog(null, response.getMessage(), "Neuspesno", JOptionPane.ERROR_MESSAGE);
            }
    }
      public void processBill(Bill b) throws Exception {
        Request request = new Request(Operations.PROCESS_BILL, b);
//        b.setUser(currentUser);
        Response response = Communication.getInstance().processBill(request);
        if (response.getResponseType().equals(ResponseType.SUCCESS)){
          JOptionPane.showMessageDialog(null, response.getMessage(), "Uspesno", JOptionPane.INFORMATION_MESSAGE);
            }else{
                 JOptionPane.showMessageDialog(null, response.getMessage(), "Neuspesno", JOptionPane.ERROR_MESSAGE);
            }
    }
     
      public void deleteBill(Bill bill) throws Exception {
        Request request = new Request(Operations.CANCEL_BILL, bill);
        Response response = Communication.getInstance().cancelBill(request);
        if (response.getResponseType().equals(ResponseType.SUCCESS)){
            JOptionPane.showMessageDialog(null, response.getMessage(), "Uspesno", JOptionPane.INFORMATION_MESSAGE);
            }else{
                 JOptionPane.showMessageDialog(null, response.getMessage(), "Neuspesno", JOptionPane.ERROR_MESSAGE);
            }
    }

    public boolean logInUser(User u) throws Exception {
        
        Request request = new Request(Operations.LOGIN,u);
        Response response=Communication.getInstance().login(request);
        List<User> listUsers = (List<User>) response.getResult();
        JOptionPane.showMessageDialog(null, response.getMessage());
        if(listUsers == null || listUsers.isEmpty()){
            return false;
        }else{
            currentUser = listUsers.get(0);
            return true;
        } 
    }

    public Product getCurrentProduct() {
        return currentProduct;
    }

    public void setCurrentProduct(Product currentProduct) {
        this.currentProduct = currentProduct;
    }

    public Bill getBill() {
        return currentBill;
    }

    public void setBill(Bill currentBill) {
        this.currentBill = currentBill;
    }
   
}
