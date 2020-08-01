package test;
import java.util.*;
import java.sql.*;
public class FuncCall {

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
			CallableStatement cs=con.prepareCall("{call ?:=Get_Balance16(?)}");
			cs.registerOutParameter(1,Types.FLOAT);
			cs.setLong(2,accno);
			cs.execute();
			System.out.println("Balance:"+cs.getFloat(1));
		}//end of if
		else
		{
			System.out.println("Invalid Account Number");
		}
		con.close();
		s.close();
	}

}
