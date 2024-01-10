/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.client.communication;

import java.net.Socket;
import rs.ac.bg.fon.ps.communication.Receiver;
import rs.ac.bg.fon.ps.communication.Request;
import rs.ac.bg.fon.ps.communication.Response;
import rs.ac.bg.fon.ps.communication.Sender;

/**
 *
 * @author Aleksandra
 */

public class Communication {
    private static Communication instance;
    private Socket socket;
    
    private Communication(){
        
    }
    
    public static Communication getInstance(){
        if (instance == null) instance = new Communication();
        return instance;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
    
    public Response login(Request request)throws Exception{
        new Sender(socket).send(request);
        System.out.println("Zahtev za prijavom na sistem je poslat...");
        return (Response) new Receiver(socket).receive();
    }
  
    public Response getAllDistributors(Request request) throws Exception {
        new Sender(socket).send(request);
        System.out.println("Zahtev getAllDistributors je poslat...");
        return (Response) new Receiver(socket).receive();
    }
      public Response addProduct(Request request) throws Exception {
        new Sender(socket).send(request);
        System.out.println("Zahtev addProduct je poslat...");
        return (Response) new Receiver(socket).receive();
    }

    public Response getProducts(Request request) throws Exception {
        new Sender(socket).send(request);
        System.out.println("Zahtev getProducts je poslat...");
        return (Response) new Receiver(socket).receive();
    }
  public Response ucitajProizvod(Request request) throws Exception {
        new Sender(socket).send(request);
        System.out.println("Zahtev ucitajProizvod je poslat...");
        return (Response) new Receiver(socket).receive();
    }
  public Response ucitajRacun(Request request) throws Exception {
        new Sender(socket).send(request);
        System.out.println("Zahtev ucitajRacun je poslat...");
        return (Response) new Receiver(socket).receive();
    }
    public Response updateProduct(Request request) throws Exception {
        new Sender(socket).send(request);
        System.out.println("Zahtev updateProduct je poslat...");
        return (Response) new Receiver(socket).receive();
    }
     public Response deleteProduct(Request request) throws Exception {
        new Sender(socket).send(request);
        System.out.println("Zahtev deleteProduct je poslat...");
        return (Response) new Receiver(socket).receive();
    }
      public Response addBill(Request request) throws Exception {
        new Sender(socket).send(request);
        System.out.println("Zahtev addBill je poslat...");
        return (Response) new Receiver(socket).receive();
    }
       public Response getBills(Request request) throws Exception {
        new Sender(socket).send(request);
        System.out.println("Zahtev getBills je poslat...");
        return (Response) new Receiver(socket).receive();
    }
        public Response cancelBill(Request request) throws Exception {
        new Sender(socket).send(request);
        System.out.println("Zahtev cancelBill je poslat...");
        return (Response) new Receiver(socket).receive();
    }
         public Response updateBill(Request request) throws Exception {
        new Sender(socket).send(request);
        System.out.println("Zahtev updateBill je poslat...");
        return (Response) new Receiver(socket).receive();
    }
       public Response processBill(Request request) throws Exception {
        new Sender(socket).send(request);
        System.out.println("Zahtev processBill je poslat...");
        return (Response) new Receiver(socket).receive();
    }
      
}
