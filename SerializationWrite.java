
package java;

import java.io.*;
import java.util.*;

class Currency implements Serializable
{
protected String currency;
protected int amount;

public Currency(String cur, int amt)
{
this.currency = cur;
this.amount = amt;
}
public String toString()
{
return currency + amount;
}
public String dollarToRupee(int amt)
{
return "Rs" + amt * 45;
}
}
class Rupee extends Currency
{
public Rupee(int amt)
{
super("Rs",amt);
}
}
class Dollar extends Currency
{
public Dollar(int amt)
{
super("$",amt);
}
}
public class SerializationWrite
{
public static void main(String args[])
{
Random r = new Random();
try
{
Currency currency;
FileOutputStream fos = new FileOutputStream("serial.txt");
ObjectOutputStream oos = new ObjectOutputStream(fos);
System.out.println("Writing to file using Object Serialization:");
for(int i=1;i<=25;i++)
{
Object[] obj = { new Rupee(r.nextInt(5000)),new Dollar(r.nextInt(5000)) };
currency = (Currency)obj[r.nextInt(2)]; // RANDOM Objects for Rs and $
System.out.println(currency);
oos.writeObject(currency);
oos.flush();
}
oos.close();
}
catch(Exception e)
{
System.out.println("Exception during Serialization: " + e);
}
}
}