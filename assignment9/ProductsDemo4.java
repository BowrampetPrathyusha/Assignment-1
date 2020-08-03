package assignment9;
import java.sql.*;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class ProductsDemo4 {

	double price;{
	try {
		JdbcRowSet rs = RowSetProvider.newFactory().createJdbcRowSet();
		rs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		rs.setUsername("DXC");
		rs.setPassword("oracle");
		rs.setCommand("select PROD_CODE,PROD_NAME,PROD_PRICE,PROD_CATALOG from PRODUCTS");
		rs.execute();
		// Update
		rs.beforeFirst();
		while (rs.next()) {
			price=Double.parseDouble(rs.getString("PROD_PRICE"));
			if(price<1000&&rs.getString("PROD_CATALOG").equals("Electronics"))
			{
				price=(price/10)+price;
				rs.updateString("PROD_PRICE",Double.toString(price));
				rs.updateRow();
			}
			if(price>1000&&rs.getString("PROD_CATALOG").equals("Clothing"))
			{
				price=price-(price/10);
				rs.updateString("PROD_PRICE",Double.toString(price));
				rs.updateRow();
			}
		}
		
		

		rs.beforeFirst();
		while (rs.next()) {
			System.out.println(rs.getString("PROD_CODE") + ":" + rs.getString("PROD_NAME") + ":"
					+ rs.getString("PROD_PRICE") + ":" + rs.getString("PROD_CATALOG"));
			
		}
	}

	catch (SQLException e) {
		System.out.println(e);
	}
	
}

}