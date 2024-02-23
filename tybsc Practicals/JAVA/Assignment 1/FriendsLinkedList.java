import java.util.LinkedList;
import java.util.Scanner;

public class FriendsLinkedList
{
       public static void main(String[] args)
       {
              Scanner scanner = new Scanner(System.in);
              LinkedList<String> friends = new LinkedList<>();
       
              System.out.print("Enter the number of friends : ");
              int n = scanner.nextInt();
              
              System.out.println();
              for (int i=0;i<n;i++)
              {
                  System.out.println("Enter the name of friends "+(i+1)+" : ");
                  String friend = scanner.next();
                  friends.add(friend);
              }
              
              System.out.println();
              System.out.println("The names of friends in the list are : ");
              for (String friend : friends)
              {
                   System.out.println(friend);
              }
       }
}
