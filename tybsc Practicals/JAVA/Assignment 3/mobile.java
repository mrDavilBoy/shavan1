import java.sql.*;
import java.util.*;

public class mobile
{
       public static void main(String[] args)
       {
              Connection conn = null;
              PreparedStatement pstmt = null;
              Statement stmt = null;
              ResultSet rs = null;
              
              try
              {
                   //Class.forName("org.postgresql.Driver");
                   conn = DriverManager.getConnection("jdbc:postgresql://192.168.1.254/exam27","exam27","exam27");
                   
                   Scanner sc = new Scanner(System.in);
                   System.out.println("\nMobile Information\n");
                   
                   do
                   {
                       System.out.println("\n1) Insert");
                       System.out.println("2) Modify");
                       System.out.println("3) Delete");
                       System.out.println("4) Search");
                       System.out.println("5) View All");
                       System.out.println("6) Exit\n");
                       
                       System.out.println("Enter your Choice : ");
                       int ch = sc.nextInt();
                       
                       switch (ch)
                       {
                              case 1 : 
                                      pstmt = conn.prepareStatement("insert into mobile values(?,?,?,?,?,?,?,?,?)");
				                      System.out.println("Enter Model Number : ");
				                      int mno = sc.nextInt();
				                      pstmt.setInt(1,mno);
				                      sc.nextLine();
				                      
				                      System.out.println("Enter Model Name : ");
				                      String mname = sc.nextLine();
				                      pstmt.setString(2,mname);
				                      
				                      System.out.println("Enter Model Color : ");
				                      String color = sc.nextLine();
				                      pstmt.setString(3,color);
				                      
				                      System.out.println("Enter Sim Type : ");
				                      String sim = sc.nextLine();
				                      pstmt.setString(4,sim);
				                      
				                      System.out.println("Enter Network Type: ");
				                      String net = sc.nextLine();
				                      pstmt.setString(5,net);
				                      
				                      System.out.println("Enter Battery Capacity : ");
				                      int Battery = sc.nextInt();
				                      pstmt.setInt(6,Battery);
				                      
				                      System.out.println("Enter Internal Storage in GB : ");
				                      int internal = sc.nextInt();
				                      pstmt.setInt(7,internal);
				                      
				                      System.out.println("Enter RAM in GB : ");
				                      int ram = sc.nextInt();
				                      pstmt.setInt(8,ram);
				                      sc.nextLine();
				                      
				                      System.out.println("Enter Processor_Type : ");
				                      String pr = sc.nextLine();
				                      pstmt.setString(9,pr);
				                      
				                      int result = pstmt.executeUpdate();
				                      System.out.println(result+"Record Inserted\n");
				                      break;
				                      
				               case 2 : 
				                       String SQL = "update mobile set model_name=? where model_number=?";
				                       pstmt = conn.prepareStatement(SQL);
				                       System.out.println("Enter Model No for Update Record : ");
				                       int no = sc.nextInt();
				                       pstmt.setInt(2,no);
				                       
				                       sc.nextLine();
				                       System.out.println("Enter Updated Model Name : ");
				                       String name = sc.nextLine();
				                       pstmt.setString(1,name);
				                       
				                       int result2 = pstmt.executeUpdate();
				                       System.out.println(result2+"Record Updated\n");
				                       break;
				               case 3 : 
				                       pstmt = conn.prepareStatement("delete from mobile where model_number=?");
				                       System.out.println("Enter Model No for Delete Record : ");
				                       int model = sc.nextInt();
				                       pstmt.setInt(1,model);
				                       
				                       int result3 = pstmt.executeUpdate();
				                       System.out.println(result3+"Record Deleted\n");
				                       break;
				               case 4 : 
				                      pstmt = conn.prepareStatement("select * from mobile where model_number=?");
				                      System.out.println("Enter Model no for search record : ");
				                      int m = sc.nextInt();
				                      pstmt.setInt(1,m);
				                      rs=pstmt.executeQuery();
				                      System.out.println("\n------------------------------------------------------------------------------------------------");
				                      while (rs.next())
				                      {
				                             System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getInt(6)+"\t"+rs.getInt(7)+"\t"+rs.getInt(8)+"\t"+rs.getString(9));
				                             
				                      }
				                      System.out.println("\n-------------------------------------------------------------------------------------------------");
				                      break;
				               case 5 : 
				                       stmt = conn.createStatement();
				                       rs = stmt.executeQuery("select * from mobile");
				                       System.out.println("\n--------------------------------------------------------------------------------------------------");
				                       while (rs.next())
				                      {
				                             System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getInt(6)+"\t"+rs.getInt(7)+"\t"+rs.getInt(8)+"\t"+rs.getString(9));
				                             
				                      }
				                      System.out.println("\n---------------------------------------------------------------------------------------------------");
				                      break;
				               case 6 : 
				                       rs.close();
				                       stmt.close();
				                       conn.close();
				                       sc.close();
				                       System.out.println("Exiting the Program........\n");
				                       System.exit(0);
				                       
                              
                       }
                   }while(true);
                   
              }
              catch (SQLException e)
              {
                     e.printStackTrace();
              }
       }
}
