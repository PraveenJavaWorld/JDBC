package test;
import java.sql.*;
import java.util.*;
public class DBCon7 {

	public static void main(String[] args) 
	throws ClassNotFoundException,SQLException{
		Scanner s=new Scanner(System.in);
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
		System.out.println("-----------CHOICE-----------");
		System.out.println("1.ViewAllProducts\n2.ViewProductByCode");
		System.out.println("Enter your choice");
		int choice=Integer.parseInt(s.nextLine());
		switch (choice) {
		case 1:
			PreparedStatement ps1=con.prepareStatement("select * from Products16");
			ResultSet rs=ps1.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+rs.getInt(4));
			}//end of while
			break;
		case 2:
			System.out.println("Enter the Code:");
			String Code=s.nextLine();
			PreparedStatement ps2=con.prepareStatement("select * from Products16 where code=?");
			ps2.setString(1,Code);
			ResultSet rs2=ps2.executeQuery();
			if(rs2.next()){
				System.out.println(rs2.getString(1)+"\t"+rs2.getString(2)+"\t"+rs2.getFloat(3)+"\t"+rs2.getInt(4));
			}//end of if
			else {
				System.out.println("Invalid Code...");
			}
			break;
			

		default:
			System.out.println("Invalid Option");
			break;
		}//end of switch
		con.close();
		s.close();
	}

}
