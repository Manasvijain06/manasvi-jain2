package manasvi2;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;


public class Manasvi2 {

    public class DataRetriever 
    {
    public static ResultSet fetchData(Connection sourceConnection) throws SQLException
    {
    String query = "SELECT * FROM source_table";
    PreparedStatement statement = sourceConnection.prepareStatement(query);
    return statement.executeQuery();
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
      try
      {
    
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url1="jdbc:mysql://localhost:3306/mysql";
        String username1="source_user";
        String password1="source_password";

        Class.forName("com.mysql.cj.jdbc.Driver");
        String url2="jdbc:postgresql://localhost:5432/target_db";
        String username2="target_user";
        String password2="target_password";
        
        
          
        Connection con1 = DriverManager.getConnection(url1,username1,password1);
        Connection con2 = DriverManager.getConnection(url2,username2,password2);
         // String q = "select* from student";
         
         
         String q1,q2;
         System.out.println("mysql>");//enter any query for database 1 and 2
         q1 =input.nextLine();
         q2 =input.nextLine();
         
         Statement stmt1 = con1.createStatement();
         Statement stmt2 = con2.createStatement();
         int count1 = stmt1.executeUpdate(q1);
         {
             System.out.println("QUERY OK,"+count1+"row affected(0.00)");
         }
         int count2 = stmt2.executeUpdate(q2);
         {
         System.out.println("QUERY OK,"+count2+"row affected(0.00)");
         }
 
          con1.close();
          con2.close();
      }
      catch(Exception e)
      {
          e.printStackTrace();
      }
     }
   }
}