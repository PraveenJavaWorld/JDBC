package test;
import java.util.*;
import java.sql.*;
public class DBCollection {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) 
	throws ClassNotFoundException,SQLException{
	ArrayList<BookData>al=new ArrayList<BookData>();
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
	PreparedStatement ps=con.prepareStatement("select * from book16");
	ResultSet rs=ps.executeQuery();
	while(rs.next())
	{
		al.add(new BookData(rs.getString(1),rs.getString(2),rs.getString(3),rs.getFloat(4),rs.getInt(5)));
	}//end of while
	System.out.println("--Dis using Extended for----");
	for(BookData bd:al)
	{
		System.out.println(bd);
	}//end of loop
	System.out.println("--Dis using Iterator<E>(old)--");
	Iterator it1=al.iterator();
	while(it1.hasNext()){
		System.out.println((BookData)it1.next());
	}//end of while
	System.out.println("--Dis using Iterator<E>(new Java8)--");
	Iterator it2=al.iterator();
	it2.forEachRemaining((z)->
	{
		System.out.println(z);
	});
	System.out.println("--Dis using forEach()(Java8)--");
	al.forEach((k)->
	{
		System.out.println(k);
	});
	con.close();
	}

}
