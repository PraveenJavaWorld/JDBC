package test;
import java.util.*;
import java.sql.*;
public class ProcCall4 {

	public static void main(String[] args) 
	throws ClassNotFoundException,SQLException{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the Employee ID");
		String id=s.nextLine();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
		PreparedStatement ps=con.prepareStatement("select * from Emp_details16 where id=?");
		ps.setString(1,id);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			CallableStatement cs=con.prepareCall("{call Retrieval16(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cs.setString(1,id);
			cs.registerOutParameter(2,Types.VARCHAR);
			cs.registerOutParameter(3,Types.VARCHAR);
			cs.registerOutParameter(4,Types.VARCHAR);
			cs.registerOutParameter(4,Types.VARCHAR);
			cs.registerOutParameter(5,Types.VARCHAR);
			cs.registerOutParameter(6,Types.VARCHAR);
			cs.registerOutParameter(7,Types.VARCHAR);
			cs.registerOutParameter(8,Types.BIGINT);
			cs.registerOutParameter(9,Types.BIGINT);
			cs.registerOutParameter(10,Types.VARCHAR);
			cs.registerOutParameter(11,Types.FLOAT);
			cs.registerOutParameter(12,Types.FLOAT);
			cs.registerOutParameter(13,Types.FLOAT);
			cs.execute();
			System.out.println("Name:"+cs.getString(2));
			System.out.println("Designation:"+cs.getString(3));
			System.out.println("DateOfBirth:"+cs.getString(4));
			System.out.println("DateOfJoin:"+cs.getString(5));
			System.out.println("HouseName:"+cs.getString(6));
			System.out.println("StreetName:"+cs.getString(7));
			System.out.println("PinCode:"+cs.getLong(8));
			System.out.println("PhoneNumber:"+cs.getLong(9));
			System.out.println("MailID:"+cs.getString(10));
			System.out.println("BasicSalary:"+cs.getFloat(11));
			System.out.println("TotalSalary:"+cs.getFloat(12));
			System.out.println("IncrementedSalary:"+cs.getFloat(13));
		}
		else
		{
			System.out.println("Invalid Employee ID");
		}
		con.close();
		s.close();
	}

}
