1.Fist Compile and run the AuctionServer.java File  (.Now you will be able to see the GUI of stocks)
2.Open another terminal connect using "nc localhost 2000" (Here the port numer is 2000)

3.Press Enter once(to enter the System)

4.When ("Enter client name:")asked enter your name in one line and press Enter.(This will be the cleint names to that connection)

5. When("Enter Symbol :") appears Enter a Symbol.
(i).........If your Symbol is valid.......
("Now you can set bids on SYMBOL current price is PRICE. New Bid :"), You will be shown like this and now you can for that. 

???(Here Symbol is Symbol you enteres and the PRICE is the price at the moment)??

(ii)..... If your Symbol is Invalid........
" -1" will be displayed
and you will be asked to ("Please enter a valid Symbol: ")

enter a valid Symbol and press Enter.

6.If your bid is greater than the current bid. Then your bid will be the new Price. It will be shown in the table.

Otherwise you will be able to see your bid with its time belowa the table.

7.Every client and its bid will be reocorded below the table 

8. If you entered a invalid bid (letters your connection will be closed).
 That is for Safety of the System.
 ******SIMPLE INSTRUCTIONS******************
 This is so user Friendly 
 
 -just open terminal and type("nc localhost 2000").(While AuctionServer Running)
 -Press Enter
 -Enter Client Name + Press Enter
 -Enter a VAlid Bid + Press Enter
 -Once you are done press Enter
 
 Enjoy the Best User Friendly AUCTION SERVER
 
 // ...Created by Amila (26.12.2018)...//
