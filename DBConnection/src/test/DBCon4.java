package test;
import java.sql.*;
import java.util.*;
public class DBCon4 {

	public static void main(String[] args) 
	throws ClassNotFoundException,SQLException{
		Scanner s=new Scanner(System.in);
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
		PreparedStatement ps=con.prepareStatement("insert into Products16 values(?,?,?,?)");
		System.out.println("How many records");
		int n=Integer.parseInt(s.nextLine());
		for(int i=0;i<n;i++)
		{
		System.out.println("Enter the Product Code");
		String Code=s.nextLine();
		ps.setString(1,Code);
		System.out.println("Enter the Product Name");
		String Name=s.nextLine();
		ps.setString(2,Name);
		System.out.println("Enter the price");
		float Price=Float.parseFloat(s.nextLine());
		ps.setFloat(3,Price);
		System.out.println("Enter the Quantity");
		int Quantity=Integer.parseInt(s.nextLine());
		ps.setInt(4,Quantity);
		int k=ps.executeUpdate();
		if(k>0)
		{
			System.out.println("Product details updated....");
		}
		}//end of loop
	con.close();
	s.close();
	}

}
