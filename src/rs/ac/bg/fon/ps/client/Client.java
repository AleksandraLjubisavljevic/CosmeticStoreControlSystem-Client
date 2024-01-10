/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.client;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import rs.ac.bg.fon.ps.client.communication.Communication;
import rs.ac.bg.fon.ps.view.form.FrmLogin;

/**
 *
 * @author Aleksandra
 */

public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        Client client = new Client();
        try {
            client.connect();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Greska pri komunikaciji sa serverom");
            System.exit(0);
        }
    }

    private void connect() throws IOException {
        Socket socket = new Socket("127.0.0.1", 9000);
        System.out.println("Klijent se povezao...");
        
        Communication.getInstance().setSocket(socket);
        new FrmLogin().setVisible(true);
    }
    
}
