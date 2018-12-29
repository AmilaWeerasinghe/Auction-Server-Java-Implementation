import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import javax.swing.*;
import java.util.*;



public class AuctionServer {

 public static final int BASE_PORT = 2000;//constant 2000 Base port to connect  
private ServerSocket serverSocket=null;  
    public StockDB stockdetails=null; //this objecct is created with values of csv file
//create a constructor to Auction server. Input is stockdetails(Object of StockDB)//this MUST BE PUBLIC ACCESD IT IS ACCESSED BY DISPALY
public static ArrayList<Client> clientList = new ArrayList<>();   //array list to keep clients objects

public AuctionServer(StockDB stock) {
	this.stockdetails = stock; 

	try { 
	    this.serverSocket = new ServerSocket(BASE_PORT); //create a new server socket
	} catch (IOException e) { 
	    System.out.println(e); 
	}
    }

public void server_loop() { 
	try { 
	    while(true) { //server is listening
		Socket socket = this.serverSocket.accept();
		 Client c = new Client(socket,stockdetails); 
		 Thread worker = new Thread(c);  //create new client
                    clientList.add(c);//add to ArrayList
                    worker.start(); 
	    }
	} catch(IOException e) { 
	    System.out.println(e);
	}
    }// end server_loop


 
    public static void main(String [] args) { 
	StockDB stockdetails = new StockDB("stocks.csv","Symbol","Security Name","Price ");//pass stocks with key value Symbol and two other values "Object neamed as stock details"
	
	 AuctionServer server = new AuctionServer(stockdetails);   //call Auction server constructor , passing created object of StockDB, from StockDB obj we can find values to given symbol
	//A gui should be implemented
	                JFrame frame = new JFrame("Bid results");  //create new gui
        frame.setSize(600, 600);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	//what should be added to the frame
	frame.add(new Display(server));   //call display constructor,
	
	 frame.pack();
        frame.setVisible(true);
	
	
	server.server_loop();// loop the created server.
    }
    
    
}
	
