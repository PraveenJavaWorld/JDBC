package test;
import java.sql.*;
import java.util.*;
public class DBCon5 {

	public static void main(String[] args) 
	throws ClassNotFoundException,SQLException{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter Username");
		String uname=s.nextLine();
		System.out.println("Enter Password");
		String password=s.nextLine();
		System.out.println("Enter FirstName");
		String fname=s.nextLine();
		System.out.println("Enter LastName");
		String lname=s.nextLine();
		System.out.println("Enter City");
		String city=s.nextLine();
		System.out.println("Enter PhoneNumber");
		float pnumber=Float.parseFloat(s.nextLine());
		System.out.println("Enter MailID");
		String mailid=s.nextLine();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
		PreparedStatement ps=con.prepareStatement("insert into userreg16 values(?,?,?,?,?,?,?)");
		ps.setString(1,uname);
		ps.setString(2,password);
		ps.setString(3,fname);
		ps.setString(4,lname);
		ps.setString(5,city);
		ps.setFloat(6,pnumber);
		ps.setString(7,mailid);
		int k=ps.executeUpdate();
		if(k>0)
		{
			System.out.println("Records Updated...");
		}
		con.close();
		s.close();
	}

}
