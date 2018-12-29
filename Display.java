import java.awt.*;
import javax.swing.Timer; //for timer
import java.text.*;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.IOException;
import java.util.*; 

public class Display extends JPanel implements ActionListener { 

AuctionServer server;
Timer timer ;
JLabel[] labels;
JButton[] showBids;
JTextArea textArea;
JPanel display,trackBids;
JLabel bids;

ArrayList<Double>[] AllBids = new ArrayList[8];


class Label{    //create label class to create label and add some styles
        JLabel lbl;
        Label(JLabel label,JPanel panel, String name){
                lbl = label = new JLabel(name);
                label.setFont(new Font("Serif", Font.PLAIN, 14));
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                label.setHorizontalAlignment(SwingConstants.CENTER);
                panel.add(label);
        }
}


class Button{   //create button class to create buttons and add some features
        JButton btn;
        Button(JButton button,JPanel panel, String name){
                btn = button = new JButton(name);
                button.addActionListener(Display.this);
                button.setFont(new Font("Serif", Font.PLAIN, 14));
                button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                button.setHorizontalAlignment(SwingConstants.CENTER);
                panel.add(button);
        }
}






    public Display(AuctionServer server) { 
        //The GIU Should be implemented input in server file by theAuction server
        
         super(new BorderLayout()); // inherite from Borderlayout
         /*Border layout gives five segments called South north east west and center. We can add one component for each*/

        for (int i=0;i<8 ;i++ ) {
                AllBids[i] = new ArrayList<>();
        }

        this.server = server;
        labels=new JLabel[27];  //about 26 labes are needed
        showBids = new JButton[8]; //about 7 buttons are needed
        display = new JPanel();
        trackBids = new JPanel();
        trackBids.setLayout(new BorderLayout());

        
         textArea = new JTextArea(10, 20);   //create text area to display all bids

                textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        trackBids.add(scrollPane);

        display.setLayout(new GridLayout(9, 4));  //create grid lay out and add labels and buttons
        
        labels[0]=new JLabel("Symbol");//Label for Symbol
         labels[0].setFont(new Font("Serif", Font.BOLD, 18));
         labels[0].setBorder(BorderFactory.createLineBorder(Color.BLACK));
         labels[0].setHorizontalAlignment(SwingConstants.CENTER);
         display.add(labels[0]);

         labels[1]=new JLabel("Name");//Label for Name
         labels[1].setFont(new Font("Serif", Font.BOLD, 18));
         labels[1].setBorder(BorderFactory.createLineBorder(Color.BLACK));
         labels[1].setHorizontalAlignment(SwingConstants.CENTER);
         display.add(labels[1]);

         labels[2]=new JLabel("Current Price");//Label for Current Price
         labels[2].setFont(new Font("Serif", Font.BOLD, 18));
         labels[2].setBorder(BorderFactory.createLineBorder(Color.BLACK));
         labels[2].setHorizontalAlignment(SwingConstants.CENTER);
         display.add(labels[2]);

         bids = new JLabel(" Show All Bids "); //new label "Show all bids"
        bids.setFont(new Font("Serif", Font.BOLD, 18));
        bids.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        bids.setHorizontalAlignment(SwingConstants.CENTER);
        display.add(bids);

/*the given FB, VRTU,
MSFT, GOOGL, YHOO, XLNX, TSLA and TXN. shold be displyed with their prices*/


//for FB
 Label l3 = new Label(labels[3],display,"FB");  //create labels and buttons
                labels[3] = l3.lbl;
                Label l4 = new Label(labels[4],display,"Facebook");
                labels[4] = l4.lbl;
                Label l5 = new Label(labels[5],display,server.stockdetails.findPrice("FB"));
                labels[5] = l5.lbl;
                Button b0 = new Button(showBids[0],display,"FB");
                showBids[0] = b0.btn; //button for show all bids that set on FB
                
                
  //for VRTU              
 Label l6 = new Label(labels[6],display,"VRTU");
                labels[6] = l6.lbl;
                Label l7 = new Label(labels[7],display,"Virtusa Corporation - common stock");
                labels[7] = l7.lbl;
                Label l8 = new Label(labels[8],display,server.stockdetails.findPrice("VRTU"));
                labels[8] = l8.lbl;
                Button b1 = new Button(showBids[1],display,"VRTU");
                showBids[1] = b1.btn;
                
    //for MSFT
     Label l9 = new Label(labels[9],display,"MSFT");
                labels[9] = l9.lbl;
                Label l10 = new Label(labels[10],display,"Microsoft Corporation - Common Stock");
                labels[10] = l10.lbl;
                Label l11 = new Label(labels[11],display,server.stockdetails.findPrice("MSFT"));
                labels[11] = l11.lbl;
                Button b2 = new Button(showBids[2],display,"MSFT");
                showBids[2] = b2.btn;            
      //for GOOGL          
       Label l12 = new Label(labels[12],display,"GOOGL");
                labels[12] = l12.lbl;
                Label l13 = new Label(labels[13],display,"Google Inc. - Class C Capital Stock");
                labels[13] = l13.lbl;
                Label l14 = new Label(labels[14],display,server.stockdetails.findPrice("GOOGL"));
                labels[14] = l14.lbl;
                Button b3 = new Button(showBids[3],display,"GOOGL");
                showBids[3] = b1.btn;
          
        //for YHOO        
         Label l15 = new Label(labels[15],display,"YHOO");
                labels[15] = l15.lbl;
                Label l16 = new Label(labels[16],display,"Yahoo! Inc. - Common Stock");
                labels[16] = l16.lbl;
                Label l17 = new Label(labels[17],display,server.stockdetails.findPrice("YHOO"));
                labels[17] = l17.lbl;
                Button b4 = new Button(showBids[4],display,"YHOO");
                showBids[4] = b1.btn;
        
        //for XLNX
         Label l18 = new Label(labels[18],display,"XLNX");
                labels[18] = l18.lbl;
                Label l19 = new Label(labels[19],display,"Xilinx");
                labels[19] = l19.lbl;
                Label l20 = new Label(labels[20],display,server.stockdetails.findPrice("XLNX"));
                labels[20] = l20.lbl;
                Button b5 = new Button(showBids[5],display,"XLNX");
                showBids[5] = b1.btn;
                
               //for TSLA 
                 Label l21 = new Label(labels[21],display,"TSLA");
                labels[21] = l21.lbl;
                Label l22 = new Label(labels[22],display,"Tesla Motors");
                labels[22] = l22.lbl;
                Label l23 = new Label(labels[23],display,server.stockdetails.findPrice("TSLA"));
                labels[23] = l23.lbl;
                Button b6 = new Button(showBids[6],display,"TSLA");
                showBids[6] = b1.btn;
                
                //for TXN
                 Label l24 = new Label(labels[24],display,"TXN");
                labels[24] = l24.lbl;
                Label l25 = new Label(labels[25],display,"Texas Instruments Incorporated - Common Stock");
                labels[25] = l25.lbl;
                Label l26 = new Label(labels[26],display,server.stockdetails.findPrice("TXN"));
                labels[26] = l26.lbl;
                Button b7 = new Button(showBids[7],display,"TXN");
                showBids[7] = b1.btn;
                
                
                
      add(display, BorderLayout.CENTER); //display BorderLayout in center
        add(trackBids, BorderLayout.SOUTH);//display trackbids at bottom

                
                
                
                
                

        
	/*textArea = new JTextArea(5, 20); 
	textArea.setEditable(false); 	
	JScrollPane scrollPane = new JScrollPane(textArea);
	
	 //Add Components to this panel.
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;

        c.fill = GridBagConstraints.HORIZONTAL;

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        add(scrollPane, c);*/

	Timer timer = new Timer(500, this); 
	timer.start(); 

	//this.server = server; 
    }
    
    public void actionPerformed(ActionEvent e) { 
	 String timeStamp;
              for(Client s: server.clientList){  //for alll clients
                     timeStamp = new SimpleDateFormat("EEE, MMM d, ''yy 'at' h:mm a").format(Calendar.getInstance().getTime()); //get system time and date
                          if(s.newbid){ //if it is a new bid
                textArea.append(timeStamp + " : " + s.clientName + " set a Bid of "+ s.bids.get(s.no_of_bids-1)+ " on "+s.symbol  +".\n");  //display details of bid
            textArea.setCaretPosition(textArea.getDocument().getLength());
            s.newbid=false;
        }

                   for(int j=0;j<=7;j++){

                        if(s.symbol != null && s.symbol.equals(labels[(j+1)*3].getText()) && (s.no_of_bids-1)>=0){ //check the symbol with the label text 

                                if(Double.compare(Double.parseDouble(labels[5 +j*3].getText()), s.bids.get(s.no_of_bids-1))<0){   //update bid if bid is greater than current price
                                labels[5 +j*3].setText(s.bids.get(s.no_of_bids-1)+"");
                                AllBids[j].add(s.bids.get(s.no_of_bids-1));
                        }
                }


                }
                }
   
    if(e.getSource() instanceof JButton) {

                String buttonSymbol = ((JButton)e.getSource()).getText();
                if(buttonSymbol.equals("FB")){
                        JOptionPane.showMessageDialog(null,"All bids for "+ buttonSymbol+"\n"+AllBids[0],"Bids for "+buttonSymbol, JOptionPane.PLAIN_MESSAGE);
                }  //when click FB button show all valid bids set on FB , on a new joptionpane window
                if(buttonSymbol.equals("VRTU")){
                        JOptionPane.showMessageDialog(null,"All bids for "+ buttonSymbol+"\n"+AllBids[1],"Bids for "+buttonSymbol, JOptionPane.PLAIN_MESSAGE);
                } //same thing to all buttons
                if(buttonSymbol.equals("MSFT")){
                        JOptionPane.showMessageDialog(null,"All bids for "+ buttonSymbol+"\n"+AllBids[2],"Bids for "+buttonSymbol, JOptionPane.PLAIN_MESSAGE);
                }
                if(buttonSymbol.equals("GOOGL")){
                        JOptionPane.showMessageDialog(null,"All bids for "+ buttonSymbol+"\n"+AllBids[3],"Bids for "+buttonSymbol, JOptionPane.PLAIN_MESSAGE);
                }
                
                if(buttonSymbol.equals("YHOO")){
                        JOptionPane.showMessageDialog(null,"All bids for "+ buttonSymbol+"\n"+AllBids[4],"Bids for "+buttonSymbol, JOptionPane.PLAIN_MESSAGE);
                }
                if(buttonSymbol.equals("XLNX")){
                        JOptionPane.showMessageDialog(null,"All bids for "+ buttonSymbol+"\n"+AllBids[5],"Bids for "+buttonSymbol, JOptionPane.PLAIN_MESSAGE);
                }
                if(buttonSymbol.equals("TSLA")){
                        JOptionPane.showMessageDialog(null,"All bids for "+ buttonSymbol+"\n"+AllBids[6],"Bids for "+buttonSymbol, JOptionPane.PLAIN_MESSAGE);
                }
                if(buttonSymbol.equals("TXN")){
                        JOptionPane.showMessageDialog(null,"All bids for "+ buttonSymbol+"\n"+AllBids[7],"Bids for "+buttonSymbol, JOptionPane.PLAIN_MESSAGE);
                }
                                               
                                               }//for s

    }// event

   /* public static void main(String [] args) throws IOException { 
	//Create and set up the window.
        JFrame frame = new JFrame("TextDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	StudentDB allowedUsers = new StudentDB("e12.csv","Student RegNo","Name");
	VisualServer server = new VisualServer(MainServer.BASE_PORT,
					       allowedUsers); 
        //Add contents to the window.
        frame.add(new Display(server));

        //Display the window.
        frame.pack();
        frame.setVisible(true);

	server.server_loop(); 
    }*/
}
	
