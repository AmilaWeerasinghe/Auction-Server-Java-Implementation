import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.*;
import java.io.*;
import java.util.*;


class Client implements Runnable { 
    // some constants 
    //public static final int WAIT_AUTH = 0; 
   // public static final int AUTH_DONE = 1;

    //public static final String WAIT_AUTH_MSG = "Registration Number pls!\n"; 
    //public static final String AUTH_DONE_MSG = "You are authorised to post\n"; 
    //public static final String MSG_POSTED    = "Your message posted\n"; 

    // per connection variables
    private Socket connectionSocket; // connection socket per thread 
    private StockDB stocks;   //to call symbols and values
    public ArrayList<Double> bids;  //to keep bids ,that one client set
    public int no_of_bids;   //index of arraylist bids
        public String  clientName , symbol=null;   //keep client name and symbol of item that client bids
    public boolean newbid=false; 
   
   
   //this constructor is called in the AuctionServer
      public Client(Socket socket, StockDB stocks) throws IOException {
                connectionSocket = socket;
                bids = new ArrayList<>(); //create new arraylist(for each client terminal seperate arraylis is created)
                this.stocks = stocks;
    }

    public void run() { // can not use "throws .." interface is different
	BufferedReader in=null; 
	PrintWriter out=null; 
	try { 
	    in = new 
		BufferedReader(new InputStreamReader(this.connectionSocket.getInputStream()));
	    out = new 
		PrintWriter(new OutputStreamWriter(this.connectionSocket.getOutputStream()));
		
	    String line, outline; 
	    int count=0;
	    out.print("Enter client Name : ");//when connected ask client for his name
	    for(line = in.readLine(); 
		line != null && !line.equals("quit"); 
		line = in.readLine()) { 	

		if(count==1){  //when enter second line ,it is client name, 
                                        clientName = line;
                                        out.print("\nEnter the symbol: "); //after get client name, ask for symbol of item

                                }
                        
                        if(count==2){

                                        symbol = line;
                                         if (stocks.stockList.containsKey(symbol)){  //Using hashMap ConatainsList check if client entered valid symbol
                                         out.print("\nNow you can set bids on "+symbol + " current price is "+ stocks.findPrice(symbol)+". New Bid : ");

                                         }
                        else{  //if client enterd wrong symbol
                                                out.print("\n-1 \n");
                                                out.print("Please enter valid Symbol: ");
                                                count = 1;
                                         }
                                }

		 if(count>2){
                                        if(count ==3){
                                                if(Double.compare(Double.parseDouble(stocks.findPrice(symbol)),Double.parseDouble(line))<0 ){  //if client enterd valid bid,(bid greater than currrnt price)
                                                bids.add(Double.parseDouble(line));
                                                newbid = true;
                                                no_of_bids++;
                                                 out.print("\nYou set a bid of "+line+" on "+symbol+". New Bid : ");


                                                }
                                                  else{
                                                out.print("\nYour Bid is not valid, current price is "+ stocks.findPrice(symbol)+". New Bid : ");
                                                count--;
                                                }
                                        }
                                        
                                         if(count>3){
                                                if(Double.compare(bids.get(no_of_bids-1),Double.parseDouble(line))<0 ) { //if client enterd valid bid,(bid greater than currrnt price)
                                                bids.add(Double.parseDouble(line));
                                                newbid = true;
                                                no_of_bids++;
                                                out.print("\nYou set a bid of "+line+" on "+symbol + ". New Bid : ");

                                                }
                                                else{
                                                out.print("\nYour Bid is not valid, current price is "+ bids.get(no_of_bids-1)+". New Bid : ");
                                                count--;
                                                }
                                        }
                                        }
		 
		out.flush(); // flush to network
                count++;
	    }
                }
                catch (IOException e) {
                    System.out.println(e);
                }finally {
                    try{this.connectionSocket.close(); }catch(Exception e){}
                }
        }
}

    

