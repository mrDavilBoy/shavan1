import java.util.Scanner;
import java.util.TreeSet;

public class SortedIntegerSet
{
       public static void main(String[] args)
       {
              Scanner scanner = new Scanner(System.in);
              TreeSet<Integer> integers = new TreeSet<>();
              
              System.out.println();
              System.out.println("Enter the number of integers : ");
              int n = scanner.nextInt();
              
              for (int i=0;i<n;i++)
              {
                   System.out.println("Enter integer "+(i+1)+" : ");
                   int integer = scanner.nextInt();
                   integers.add(integer);
              }
              
              System.out.println();
              System.out.println("The Sorted integers are : ");
              for (int integer : integers)
              {
                   System.out.println(integer);
              }
       }
}
