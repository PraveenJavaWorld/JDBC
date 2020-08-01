package test;
import java.sql.*;
public class BatchProc1 {

	public static void main(String[] args)
	throws ClassNotFoundException,SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
		Statement stm=con.createStatement();
		stm.addBatch("insert into bank16 values(891234567,'Sruthi',60000,'Savings')");
		stm.addBatch("insert into personal_details16 values(891234567,'Hyderabad',9618041334,'Sruthi@gmail.com')");
		int k[]=stm.executeBatch();
		for(int i=0;i<k.length;i++)
		{
			System.out.println("Query"+(i+1)+"Executed:"+k[i]);
		}//end of loop
		con.close();

	}

}
