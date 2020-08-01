package test;
import java.util.*;
import java.sql.*;
public class ProcCall3 {

	public static void main(String[] args)
	throws ClassNotFoundException,SQLException{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the Account Number");
		Long accno=Long.parseLong(s.nextLine());
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
		PreparedStatement ps=con.prepareStatement("select * from bank16 where accountnumber=?");
		ps.setLong(1,accno);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			CallableStatement cs=con.prepareCall("{call retrieve16(?,?,?,?,?,?,?)}");
			cs.setLong(1,accno);
			cs.registerOutParameter(2,Types.VARCHAR);
			cs.registerOutParameter(3,Types.FLOAT);
			cs.registerOutParameter(4,Types.VARCHAR);
			cs.registerOutParameter(5,Types.VARCHAR);
			cs.registerOutParameter(6,Types.BIGINT);
			cs.registerOutParameter(7,Types.VARCHAR);
			cs.execute();
			System.out.println("Name:"+cs.getString(2));
			System.out.println("Balance:"+cs.getFloat(3));
			System.out.println("AccountType:"+cs.getString(4));
			System.out.println("Address:"+cs.getString(5));
			System.out.println("PhoneNumber:"+cs.getLong(6));
			System.out.println("MailID:"+cs.getString(7));
		}
		else
		{
			System.out.println("Invalid Account Number");
		}
		con.close();
		s.close();
	}

}
