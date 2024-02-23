import java.util.HashMap;
import java.util.Map;

public class ContactHashTable
{
       public static void main(String[] args)
       {
              Map<String,String> contacts = new HashMap<>();
              
              contacts.put("8305678311","Harsh");
              contacts.put("2349730961","Shivam");
              contacts.put("9730966860","Aman");
              contacts.put("9737971953","Uddhav");
              contacts.put("8976543245","Vinay");
              
              System.out.println("The contacts list is : ");
              for (Map.Entry<String,String> contact : contacts.entrySet())
              {
                   System.out.println(contact.getKey()+" - "+contact.getValue());
              }
       }
}
