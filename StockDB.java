import java.io.*;
import java.util.*;

class StockDB { 

/*We must include Price and Security Name. But we have given  HashMap. HashMap cannot inclued two values other than the key.
The solution i made was to create class which can have two Strings(Security name and Price) in it. And pass the objects of that class into the HashMap
 */

class TwoValues {
    String sName;   //we cant keep two values on a hashmap, so i create a object that includes that two values and keep that object as a value in hash map
    String price;


    public TwoValues(String a, String b) {
        sName = a;
        price = b;
    }
}


//Now the inputs are Stirng(Symbol) and TwoValues objects
    public Map<String, TwoValues> stockList; //My hashmap should be public acced because this is accessed by the client Class
    private String [] fields; 
//for StockDB constuctor all values of csv file is passed
    public StockDB(String cvsFile, String key, String sName,String price)  { 
	FileReader fileRd=null; 
	BufferedReader reader=null; 

	try { 
	    fileRd = new FileReader(cvsFile); 
	    reader = new BufferedReader(fileRd); 

	    /* read the CSV file's first line which has 
	     * the names of fields. 
	     */
	    String header = reader.readLine(); 
	    fields = header.split(",");// keep field names 

	    // find where the key and the value are
	     
	    int keyIndex = findIndexOf(key); //find the index of key .Here the Key=Symbol
	    int sNameIndex = findIndexOf(sName);//index of Security Name
	    int priceIndex = findIndexOf(price); //index of price

	    if(keyIndex == -1 || sNameIndex == -1 || priceIndex==-1) //check if any of value do not exist
		throw new IOException("CVS file does not have data"); 
	    // note how you can throw a new exception 

	    // get a new hash map after the header
	    stockList = new HashMap<String, TwoValues>(); 

	    /* read each line, getting it split by , 
	     * use the indexes to get the key and value 
	     */
	    String [] tokens; 
	    for(String line = reader.readLine(); 
		line != null; 
		line = reader.readLine()) { 
		tokens = line.split(","); 
		stockList.put(tokens[keyIndex], new TwoValues(tokens[sNameIndex],tokens[priceIndex])); //put each entry in to stockList 
	    }
	    
	    if(fileRd != null) fileRd.close();
	    if(reader != null) reader.close();
	    
	    // I can catch more than one exceptions 
	} catch (IOException e) { 
	    System.out.println(e);
	    System.exit(-1); 
	} catch (ArrayIndexOutOfBoundsException e) { 
	    System.out.println("Malformed CSV file");
	    System.out.println(e);
	}
    }
//given method to find Index Of key
    private int findIndexOf(String key) { 
	for(int i=0; i < fields.length; i++) 
	    if(fields[i].equals(key)) return i; 
	return -1; 
    }
	
    // public interface 
    //method to return sNAme of given key in the HashMap
    public String findSName(String key) { 
	return stockList.get(key).sName; 
    }
    //method to find Price
     public String findPrice(String key) { 
	return stockList.get(key).price; 
    }

}
	    
