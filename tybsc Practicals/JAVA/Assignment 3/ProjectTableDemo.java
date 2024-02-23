import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ProjectTableDemo extends JFrame
{
       //private static final String DB_URL = "jdbc:postgres//192.168.1.254:5432/exam27";
       //private static final String USER = "exam27";
       //private static final String PASS ="exam27";
       
       public ProjectTableDemo()
       {
              super("Project Table Demo");
              setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              setSize(600,400);
              setLocationRelativeTo(null);
              getContentPane().add(new JScrollPane(getProjectTable()));
              setVisible(true);
       }
       private JTable getProjectTable()
       {
               String[] columns = {"Project ID","Project Name","Project Description","Project Status"};
               DefaultTableModel model = new DefaultTableModel(columns,0);
               
               try
               {
                   Connection conn = DriverManager.getConnection("jdbc:postgresql://192.168.1.254/exam27","exam27","exam27");
                   Statement stmt = conn.createStatement();
                   stmt.executeUpdate("CREATE TABLE IF NOT EXISTS PROJECT("+"PROJECT_ID INT PRIMARY KEY,"+"PROJECT_NAME VARCHAR(255),"+"PROJECT_DESCRIPTION VARCHAR(255),"+"PROJECT_STATUS VARCHAR(255)"+")");
                   
                   stmt.executeUpdate("INSERT INTO PROJECT(PROJECT_ID,PROJECT_NAME,PROJECT_DESCRIPTION,PROJECT_STATUS) VALUES(1,'TODO LIST','Create Application','IN PROGRESS')");
                   
                   stmt.executeUpdate("INSERT INTO PROJECT(PROJECT_ID,PROJECT_NAME,PROJECT_DESCRIPTION,PROJECT_STATUS) VALUES(2,'Documentation','Creating Documentation','COMPLETED')");
                   
                   ResultSet rs = stmt.executeQuery("SELECT * FROM PROJECT");
                   
                   while (rs.next())
                   {
                          int id = rs.getInt("PROJECT_ID");
                          String name = rs.getString("PROJECT_NAME");
                          String desc = rs.getString("PROJECT_DESCRIPTION");
                          String status = rs.getString("PROJECT_STATUS");
                          model.addRow(new Object[]{id,name,desc,status});
                   }
                   conn.close();
               }
               catch (SQLException e)
               {
                     e.printStackTrace();
               }
               return new JTable(model);
       }
       public static void main(String[] args)
       {
              new ProjectTableDemo();
       }
}
