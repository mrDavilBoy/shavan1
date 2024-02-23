import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortHashMap
{
       public static void main(String[] args)
       {
              Map<String,Integer>details = new HashMap<>();
              
              details.put("Harsh",21);
              details.put("Shivam",19);
              details.put("Vinay",20);
              details.put("Uddhav",60);
              details.put("Aman",23);
              
              System.out.println("The details before sorting are : ");
              
              for (Map.Entry<String,Integer> entry : details.entrySet())
              {
                   System.out.println(entry.getKey()+" - "+entry.getValue());
              }
              
              Map<String,Integer> sortedDetails = new TreeMap<>(details);
              
              System.out.println("\nThe details after sorting are : ");
              
              for (Map.Entry<String,Integer> entry : sortedDetails.entrySet())
              {
                   System.out.println(entry.getKey()+" - "+entry.getValue());
              }
              
       }
}
