import java.sql.*;

public class ColumnInfoDemo
{
       public static void main(String[] args)
       {
              try (Connection conn = DriverManager.getConnection("jdbc:postgresql://192.168.1.254/exam27","exam27","exam27"))
              {
                  Statement stmt = conn.createStatement();
                  ResultSet rs = stmt.executeQuery("SELECT * FROM DONOR");
                  
                  ResultSetMetaData metaData = rs.getMetaData();
                  
                  int columnCount = metaData.getColumnCount();
                  System.out.println("Number of Columns: "+columnCount);
                  
                  int i;
                  for (i=1;i<=columnCount;i++)
                  {
                       System.out.println("Column Name : "+metaData.getColumnName(i));
                       System.out.println("Column Type : "+metaData.getColumnTypeName(i));
                       System.out.println("Column Size : "+metaData.getColumnDisplaySize(i));
                       System.out.println("Is Nullable : "+metaData.isNullable(i));
                       System.out.println();
                       
                  }
                  rs.close();
                  stmt.close();
                  conn.close();
              }
              catch (SQLException e)
              {
                    e.printStackTrace();
              }
       }
}
