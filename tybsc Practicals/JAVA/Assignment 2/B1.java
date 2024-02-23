import java.util.*;

class Sum_Thread implements Runnable
{
      Thread t;
      int a[] = new int[1000];
      int no,sum;
      
      Sum_Thread (String s, int n)
      {
                  Random r = new Random();
                  t = new Thread(this,s);
                  int j = 0;
                  no = n;
                  
                  for (int i=0;i<1000;i++)
                  {
                       a[i] = r.nextInt(1000);
                       j++;
                  }
                  t.start();
      }
      
      public void run()
      {
             try
             {
                 for (int i =0;i<100;i++)
                 {
                      System.out.print(a[no]+" ");
                      sum = sum +a[no];
                      no++;
                 }
                 System.out.println("");
                 System.out.println("SUM : "+sum);
                 System.out.println("AVG : "+sum/100);
                 System.out.println("");
             }
             catch (Exception e)
             {
                    e.printStackTrace();
             }
      }
}

public class B1
{
       public static void main(String[] args)
       {
              try
              {
		          Sum_Thread t1 = new Sum_Thread("t1",1);
		          t1.t.join();
		          
		          Sum_Thread t2 = new Sum_Thread("t2",100);
		          t2.t.join();
		          
		          Sum_Thread t3 = new Sum_Thread("t3",200);
		          t3.t.join();
		          
		          Sum_Thread t4 = new Sum_Thread("t4",300);
		          t4.t.join();
		          
		          Sum_Thread t5 = new Sum_Thread("t5",400);
		          t5.t.join();
		          
		          Sum_Thread t6 = new Sum_Thread("t6",500);
		          t6.t.join();
		          
		          Sum_Thread t7 = new Sum_Thread("t7",600);
		          t7.t.join();
		          
		          Sum_Thread t8 = new Sum_Thread("t8",700);
		          t8.t.join();
		          
		          Sum_Thread t9 = new Sum_Thread("t9",800);
		          t9.t.join();
		          
		          Sum_Thread t10 = new Sum_Thread("t10",900);
		          t10.t.join();
              }
              catch(Exception e)
              {
                    e.printStackTrace();
              }
       }
}
