package assignment9;
import java.sql.*;

public class ProductsDemo1 {
	public static void main(String args[]) { 
        //Creating the connection 
        String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
        String user = "DXC"; 
        String pass = "oracle"; 
  
       
  
        
        Connection con=null; 
        String sql="select * from PRODUCTS";
        try
        { 
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver()); 
  
           
            con = DriverManager.getConnection(url,user,pass); 
  
            Statement st = con.createStatement(); 
            ResultSet result=st.executeQuery(sql);
            
          while(result.next()) {
        	  System.out.println(result.getString("PROD_CODE") +":"+result.getString("PROD_NAME")+":"+result.getString("PROD_PRICE")+":"+result.getString("PROD_CATALOG"));
          }
        	  
           
        } 
        catch(Exception e) 
        { 
            System.out.println(e); 
        } 
        finally {
        	 
        	try{
        		con.close(); 
        	}
        	catch(SQLException e) {
        		System.out.println(e);
        	}
		}
    } 
} 
