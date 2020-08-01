package test;
import java.sql.*;
public class BatchProc2 {

	public static void main(String[] args) 
	throws ClassNotFoundException,SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
		PreparedStatement ps=con.prepareStatement("insert into Product16 values(?,?,?,?)");
		ps.setString(1,"A126");
		ps.setString(2,"RAM");
		ps.setFloat(3,4500.85f);
		ps.setInt(4,8);
		ps.addBatch();

		ps.setString(1,"A127");
		ps.setString(2,"Printer");
		ps.setFloat(3,5500.85f);
		ps.setInt(4,5);
		ps.addBatch();
		int k[]=ps.executeBatch();
		for(int i=0;i<k.length;i++)
		{
			System.out.println("Query"+(i+1)+"Executed:"+k[i]);
		}//end of loop
		con.close();
	}

}
