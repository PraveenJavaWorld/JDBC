package test;
import java.util.*;
import java.sql.*;
public class DBMap1 {

	public static void main(String[] args) 
	throws ClassNotFoundException,SQLException{
	HashMap<String,ProductData1> hm=new HashMap<String,ProductData1>();
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
	PreparedStatement ps=con.prepareStatement("select * from Product16");
	ResultSet rs=ps.executeQuery();
	while(rs.next()){
		hm.put(rs.getString(1),new ProductData1(rs.getString(2),rs.getDouble(3),rs.getInt(4)));
	}//end of while
	System.out.println("----Dis Product Details----");
	hm.forEach((p,q)->
	{
		System.out.println(p+"\t"+q);
	});	
	con.close();
	}

}
