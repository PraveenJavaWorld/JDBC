package test;
import java.util.*;
import java.sql.*;
public class ProcCall1 {

	public static void main(String[] args)
	throws ClassNotFoundException,SQLException{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the AccountNumber");
		Long accno=Long.parseLong(s.nextLine());
		System.out.println("Enter Customer Name");
		String name=s.nextLine();
		System.out.println("Enter the Balance");
		float bal=Float.parseFloat(s.nextLine());
		System.out.println("Enter Account Type");
		String actype=s.nextLine();
		System.out.println("Enter the Address");
		String address=s.nextLine();
		System.out.println("Enter the PhoneNumber");
		Long phno=Long.parseLong(s.nextLine());
		System.out.println("Enter MailID");
		String mail=s.nextLine();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
		CallableStatement cs=con.prepareCall("{Call Create_Account16(?,?,?,?,?,?,?)}");
		cs.setLong(1,accno);
		cs.setString(2,name);
		cs.setFloat(3,bal);
		cs.setString(4,actype);
		cs.setString(5,address);
		cs.setLong(6,phno);
		cs.setString(7,mail);
		boolean k=cs.execute();
		if(k)
		{
		System.out.println("Account Created Successfully");
		}
		con.close();
		s.close();
	}

}
