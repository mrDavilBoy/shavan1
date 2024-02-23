import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

public class PhoneBook
{
       public static void main(String[] args) throws IOException
       {
              Hashtable<String,String> phoneBook = new Hashtable<>();
              BufferedReader reader = new BufferedReader(new FileReader("phonebook.txt"));
              
              String line;
              
              while ((line = reader.readLine())!=null)
              {
                     String[] fields = line.split("\t");
                     phoneBook.put(fields[0],fields[1]);
              }
              reader.close();
              
              System.out.println("Enter a name to look up : ");
              String name = System.console().readLine();
              String phoneNumber = phoneBook.get(name);
              
              if (phoneNumber!=null)
              {
                  System.out.println("The phone number for "+name+" is " +phoneNumber);
              }
              else
              {
                  System.out.println("No Phone number found for"+name);
              }
              
              System.out.println("Enter a phone number to look up : ");
              
              String number = System.console().readLine();
              String foundName = null;
              
              for (String nameKey : phoneBook.Set())
              {
                   String phoneNumberValue = phoneBook.get(nameKey);
                   if (phoneNumberValue.equals(number))
                   {
                       foundName = nameKey;
                       break;
                   }
                   
              }
              if (foundName!=null)
                   {
                       System.out.println("The name corresponding to "+number+" is " + foundName);
                   }
                   else
                   {
                       System.out.println("No Name found Corresponding to "+number);
                   }
       }
}
