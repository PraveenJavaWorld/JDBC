package test;
import java.sql.*;
import java.util.*;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
public class DRowSet2 {

	public static void main(String[] args) 
	throws ClassNotFoundException,SQLException{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the Account Number");
		long accno=Long.parseLong(s.nextLine());
		Class.forName("oracle.jdbc.driver.OracleDriver");
		JdbcRowSet jrs=RowSetProvider.newFactory().createJdbcRowSet();
		jrs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		jrs.setUsername("system");
		jrs.setPassword("1234");
		jrs.setCommand("select * from bank16 where accountnumber=?");
		jrs.setLong(1,accno);
		jrs.execute();
		System.out.println("---Dis Normal---");
		if(jrs.next())
		{
			System.out.println(jrs.getLong(1)+"\t"+jrs.getString(2)+"\t"+jrs.getFloat(3)+"\t"+jrs.getString(4));
		}//end of if
		else
		{
			System.out.println("Invalid Account Number");
		}
		s.close();
	}

}
