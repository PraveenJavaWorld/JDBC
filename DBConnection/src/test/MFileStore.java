package test;
import java.util.*;
import java.io.*;
import java.sql.*;
public class MFileStore {

	public static void main(String[] args) 
	throws ClassNotFoundException,IOException,SQLException{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter ID");
		String ID=s.nextLine();
		System.out.println("Enter FilePath(Source)");
		String fpath=s.nextLine();
		File f=new File(fpath);
		FileInputStream fis=new FileInputStream(f);
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
		PreparedStatement ps=con.prepareStatement("insert into MFStore16 values(?,?)");
		ps.setString(1,ID);
		ps.setBinaryStream(2,fis,(int)f.length());
		int k=ps.executeUpdate();
		if(k>0){
			System.out.println("MFile Stored Successfully....");
		}
		con.close();
		s.close();
	}

}
