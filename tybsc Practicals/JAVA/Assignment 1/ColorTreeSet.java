import java.util.TreeSet;

public class ColorTreeSet
{
       public static void main(String[] args)
       {
              TreeSet<String> colors = new TreeSet<>();
              
              colors.add("red");
              colors.add("green");
              colors.add("blue");
              colors.add("yellow");
              colors.add("orange");
              
              System.out.println("The colors in the TreeSet are : ");
              
              for (String color : colors)
              {
                  System.out.println(color);
              }
       }
}
