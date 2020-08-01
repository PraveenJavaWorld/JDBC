package test;
import java.sql.*;
import java.util.*;
public class DBCon6 {

	public static void main(String[] args)
	throws ClassNotFoundException,SQLException{
		Scanner s=new Scanner(System.in);
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
		PreparedStatement ps=con.prepareStatement("insert into train16 values(?,?,?,?,?)");
		System.out.println("How many Records");
		int n=Integer.parseInt(s.nextLine());
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter the TrainNumber");
			long number=Long.parseLong(s.nextLine());
			ps.setLong(1,number);
			System.out.println("Enter the TrainName");
			String name=s.nextLine();
			ps.setString(2,name);
			System.out.println("Enter the FirstStation");
			String fstation=s.nextLine();
			ps.setString(3,fstation);
			System.out.println("Enter the LastStation");
			String lstation=s.nextLine();
			ps.setString(4,lstation);
			System.out.println("Enter the Availability");
			String avail=s.nextLine();
			ps.setString(5,avail);
			int k=ps.executeUpdate();
			if(k>0)
			{
				System.out.println("Records Updated...");
			}
		}//end of loop
		con.close();
		s.close();

	}

}
