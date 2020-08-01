package test;
import java.sql.*;
public class MetaData {

	public static void main(String[] args)
	throws ClassNotFoundException,SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
		DatabaseMetaData dmd=con.getMetaData();
		System.out.println("---DataBase Meta Data---");
		System.out.println("DriverName:"+dmd.getDriverName());
		PreparedStatement ps=con.prepareStatement("select * from product16 where code=?");
		ps.setString(1,"A121");
		ParameterMetaData pmd=ps.getParameterMetaData();
		System.out.println("---Parameter Meta Data---");
		System.out.println("ParameterCount:"+pmd.getParameterCount());
		ResultSet rs=ps.executeQuery();
		ResultSetMetaData rsmd=rs.getMetaData();
		System.out.println("---ResultSet Meta Data---");
		System.out.println("ColumnCount:"+rsmd.getColumnCount());
		con.close();

	}

}
