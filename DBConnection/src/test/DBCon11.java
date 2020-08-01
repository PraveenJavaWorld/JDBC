package test;
import java.util.*;
import java.sql.*;
public class DBCon11 {

	public static void main(String[] args) 
	throws ClassNotFoundException,SQLException {
		Scanner s=new Scanner(System.in);
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
		PreparedStatement ps1=con.prepareStatement("select * from userreg16 where username=? and password=?");
		System.out.println("Enter the Username");
		String uname=s.nextLine();
		ps1.setString(1,uname);
		System.out.println("Enter Password");
		String password=s.nextLine();
		ps1.setString(2,password);
		ResultSet rs=ps1.executeQuery();
		if(rs.next())
		{
			System.out.println("Old Number is:"+rs.getLong(6));
			PreparedStatement ps2=con.prepareStatement("update userreg16 set phonenumber=? where username=?");
			System.out.println("Enter the New PhoneNumber");
			ps2.setLong(1,Long.parseLong(s.nextLine()));
			ps2.setString(2,uname);
			int k=ps2.executeUpdate();
			if(k>0)
			{
				System.out.println("PhoneNumber Updated...");
			}
		}//end of if
		else 
		{
			System.out.println("Invalid Username and Password");
		}
		con.close();
		s.close();
	}

}
