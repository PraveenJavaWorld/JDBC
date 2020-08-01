package test;
import java.util.*;
import java.sql.*;
public class DBCollection1 {

	public static void main(String[] args)
	throws ClassNotFoundException,SQLException{
		ArrayList<ProductData> al=new ArrayList<ProductData>();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
		PreparedStatement ps=con.prepareStatement("select * from product16");
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			al.add(new ProductData(rs.getString(1),rs.getString(2),rs.getDouble(3),rs.getInt(4)));
		}//end of while
		System.out.println("----Using forEach()----");
		al.forEach((k)->
		{
			System.out.println(k);	
		});
		con.close();
	}

}
