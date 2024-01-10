/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.validation;

import java.awt.Color;
import java.math.BigDecimal;
import javax.swing.BorderFactory;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Aleksandra
 */
public class ValidationForms {
    private static ValidationForms instance;
    String validationMessage = "";
    
    private ValidationForms(){
        
    }

    public static ValidationForms getInstance() {
        if(instance == null)
            instance = new ValidationForms();
        return instance;
    }
    
    public boolean validateEmpty(JTextField... textF){
        boolean valid = true;
        for (JTextField oneField : textF) {
            if("".equals(oneField.getText())){
              
                valid = false;
            }
        }
        
        if(!valid)
        validationMessage="Sva polja moraju biti popunjena";
        return valid;
    }
    
    public boolean validateEmpty1(JTextArea... textA){
        boolean valid = true;
        
        for (JTextArea one : textA) {
            if("".equals(one.getText())){
                valid = false;
            }
        }
        
        if(!valid)
        validationMessage="Sva polja moraju biti popunjena";
        return valid;
    }

    public String getValidationMessage() {
        return validationMessage;
    }

    public boolean validateValueIsNumber(String tekst){
      
        try{
            if(tekst!=null){
                new BigDecimal(tekst);
                return true;
                
            }else{
                validationMessage="Nedozvoljena vrednost ("+tekst+" ). Morate uneti numericku vrednost";
                return false;
            }
        }catch(NumberFormatException ex){
            validationMessage="Nedozvoljena vrednost ("+tekst+" ). Morate uneti numericku vrednost";
            return false;
        }
    }

 
}
