package test;
import java.sql.*;
import java.util.*;
public class DBCon3 {

	public static void main(String[] args)
	throws ClassNotFoundException,SQLException{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the Product Code");
		String Code=s.nextLine();
		System.out.println("Enter the Product Name");
		String Name=s.nextLine();
		System.out.println("Enter the price");
		float Price=Float.parseFloat(s.nextLine());
		System.out.println("Enter the Quantity");
		int Quantity=Integer.parseInt(s.nextLine());
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
		PreparedStatement ps=con.prepareStatement("insert into Products16 values(?,?,?,?)");
		ps.setString(1,Code);
		ps.setString(2,Name);
		ps.setFloat(3,Price);
		ps.setInt(4,Quantity);
		int k=ps.executeUpdate();
		if(k>0)
		{
			System.out.println("Product details updated....");
		}
		con.close();
		s.close();
	}

}
