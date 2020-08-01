package test;
import java.util.*;
import java.sql.*;
public class DBMap {

	public static void main(String[] args) 
	throws ClassNotFoundException,SQLException{
	HashMap<String,BookData1> hm=new HashMap<String,BookData1>();
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
	PreparedStatement ps=con.prepareStatement("select * from Book16");
	ResultSet rs=ps.executeQuery();
	while(rs.next()){
		hm.put(rs.getString(1),new BookData1(rs.getString(1),rs.getString(3),rs.getFloat(4),rs.getInt(5)));
	}//end of while
	System.out.println("--Dis Book Details--");
	hm.forEach((p,q)->
	{
		System.out.println(p+"\t"+q);
	});
	con.close();
	}

}
