import java.sql.*;

public class DatabaseInfoDemo
{
        public static void main(String[] args)
        {
               try (Connection conn = DriverManager.getConnection("jdbc:postgresql://192.168.1.254/exam27","exam27","exam27"))
               {
                   DatabaseMetaData metaData = conn.getMetaData();
                   System.out.println("Database Product Name : "+metaData.getDatabaseProductName());
                   System.out.println("Database Product Version : "+metaData.getDatabaseProductVersion());
                   System.out.println("Driver Name : "+metaData.getDriverName());
                   System.out.println("Driver Version : "+metaData.getDriverVersion());
                   System.out.println();
                   
                   ResultSet rs = metaData.getTables(null,null,"%",new String[]{"TABLE"});
                   
                   System.out.println("Tables in the database : ");
                   while (rs.next())
                   {
                          String tableName = rs.getString("TABLE_NAME");
                          System.out.println(tableName);
                   }
                   rs.close();
                   conn.close();
               }
               catch (SQLException e)
               {
                     e.printStackTrace();
               }
        }
}
