package test;
import java.util.*;
import java.sql.*;
public class DBCon10 {

	public static void main(String[] args) 
	throws ClassNotFoundException,SQLException{
		Scanner s=new Scanner(System.in);
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
		System.out.println("-----CHOICE-----");
		System.out.println("1.User Registration\n2.User Login\n3.View User Details");
		System.out.println("Enter Your Choice");
		int choice=Integer.parseInt(s.nextLine());
		switch (choice) 
		{
		case 1:
			PreparedStatement ps1=con.prepareStatement("insert into userreg16 values(?,?,?,?,?,?,?)");
			System.out.println("Enter the Username");
			ps1.setString(1,s.nextLine());
			System.out.println("Enter the Password");
			ps1.setString(2,s.nextLine());
			System.out.println("Enter the Firstname");
			ps1.setString(3,s.nextLine());
			System.out.println("Enter the Lastname");
			ps1.setString(4,s.nextLine());
			System.out.println("Enter the City");
			ps1.setString(5,s.nextLine());
			System.out.println("Enter the PhoneNumber");
			ps1.setLong(6,Long.parseLong(s.nextLine()));
			System.out.println("Enter the mailID");
			ps1.setString(7,s.nextLine());
			int k=ps1.executeUpdate();
			if(k>0)
			{
				System.out.println("User Registered Successfully.....");
			}
			break;
		case 2:
			PreparedStatement ps2=con.prepareStatement("select * from Userreg16 where username=? and Password=?");
			System.out.println("Enter the Username");
			ps2.setString(1,s.nextLine());
			System.out.println("Enter Password");
			ps2.setString(2,s.nextLine());
			ResultSet rs1=ps2.executeQuery();
			if(rs1.next())
			{
				System.out.println("User Logged in Successfully....");
			}//end of if
			else{
				System.out.println("Invalid Credentials");
			}
			break;
		case 3:
			PreparedStatement ps3=con.prepareStatement("select * from Userreg16 where Username=? and Password=?");
			System.out.println("Enter the Username");
			ps3.setString(1,s.nextLine());
			System.out.println("Enter Password");
			ps3.setString(2,s.nextLine());
			ResultSet rs2=ps3.executeQuery();
			if(rs2.next())
			{
				System.out.println("FirstName="+rs2.getString(3));
				System.out.println("LastName="+rs2.getString(4));
				System.out.println("City="+rs2.getString(5));
				System.out.println("PhoneNumber="+rs2.getString(6));
				System.out.println("MailID="+rs2.getString(7));
			}//end of if
			else
			{
				System.out.println("Invalid Credentials");
			}
			break;
		default:
			System.out.println("Invalid Choice");
		}//end of switch
		s.close();
		con.close();
	}

}
