package test;
import java.util.*;
import java.sql.*;
import java.io.*;
public class MFileRetrieve {

	public static void main(String[] args)
	throws ClassNotFoundException,SQLException,IOException{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter ID");
		String id=s.nextLine();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
		PreparedStatement ps=con.prepareStatement("select * from MFStore16 where id=?");
		ps.setString(1,id);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			Blob b=rs.getBlob(2);
			byte by[]=b.getBytes(1,(int)b.length());
			System.out.println("Enter the fpath & name(Destination)");
			String fpath=s.nextLine();
			FileOutputStream fos=new FileOutputStream(fpath);
			fos.write(by);
			System.out.println("Multimedia File Retrieved Successfully");
			fos.close();
		}//end of if
		else
		{
			System.out.println("Invalid ID");
		}
		con.close();
		s.close();
	}

}
