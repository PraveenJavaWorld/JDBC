package test;
import java.util.*;
import java.sql.*;
public class DBCon12 {

	public static void main(String[] args)
	throws ClassNotFoundException,SQLException{
		Scanner s=new Scanner(System.in);
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
		PreparedStatement ps1=con.prepareStatement("select * from book16 where code=?");
		System.out.println("Enter the Book Code");
		String code=s.nextLine();
		ps1.setString(1,code);
		ResultSet rs=ps1.executeQuery();
		if(rs.next())
		{
			PreparedStatement ps2=con.prepareStatement("delete from book16 where code=?");
			ps2.setString(1,code);
			int k=ps2.executeUpdate();
			if(k>0)
			{
				System.out.println("Record Deleted...");
			}
		}//end of if
		else
		{
			System.out.println("Invalid Code");
		}
		con.close();
		s.close();
	}

}
