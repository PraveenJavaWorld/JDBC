package test;
import java.sql.*;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
public class DRowSet1 {

	public static void main(String[] args)
	throws ClassNotFoundException,SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		JdbcRowSet jrs=RowSetProvider.newFactory().createJdbcRowSet();
		jrs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		jrs.setUsername("system");
		jrs.setPassword("1234");
		jrs.setCommand("select * from Product16");
		jrs.execute();
		System.out.println("---Dis Normal---");
		while(jrs.next()){
			System.out.println(jrs.getString(1)+"\t"+jrs.getString(2)+"\t"+jrs.getFloat(3)+"\t"+jrs.getInt(4));
		}//end of while
		System.out.println("---Dis in Reverse---");
		jrs.afterLast();
		while(jrs.previous()){
			System.out.println(jrs.getString(1)+"\t"+jrs.getString(2)+"\t"+jrs.getFloat(3)+"\t"+jrs.getInt(4));
		}//end of while
		

	}

}
