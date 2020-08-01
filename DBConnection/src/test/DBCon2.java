package test;
import java.sql.*;
public class DBCon2 {

	public static void main(String[] args)
			throws ClassNotFoundException,SQLException{
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
		Statement stm=con.createStatement();
		ResultSet rs=stm.executeQuery("select * from Book16");
		while(rs.next()){
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getInt(5));
		}//End of While
		con.close();
	}

}
