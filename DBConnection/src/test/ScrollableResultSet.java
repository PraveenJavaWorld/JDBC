package test;
import java.sql.*;
public class ScrollableResultSet {

	public static void main(String[] args) 
	throws ClassNotFoundException,SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
		Statement stm=con.createStatement(1004,1007);
		ResultSet rs1=stm.executeQuery("select * from Book16");
		System.out.println("---Display data in reverse---");
		rs1.afterLast();
		while(rs1.previous())
		{
			System.out.println(rs1.getString(1)+"\t"+rs1.getString(2)+"\t"+rs1.getString(3)+"\t"+rs1.getFloat(4)+"\t"+rs1.getInt(5));
		}//end of loop
		PreparedStatement ps=con.prepareStatement("select * from Book16",1004,1007);
		ResultSet rs2=ps.executeQuery();
		System.out.println("---Display absolute record(2)---");
		rs2.absolute(2);
		System.out.println(rs2.getString(1)+"\t"+rs2.getString(2)+"\t"+rs2.getString(3)+"\t"+rs2.getFloat(4)+"\t"+rs2.getInt(5));
		con.close();
	}

}
