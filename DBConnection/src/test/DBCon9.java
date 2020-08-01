package test;
import java.sql.*;
import java.util.*;
public class DBCon9 {

	public static void main(String[] args) 
	throws ClassNotFoundException,SQLException{
		Scanner s=new Scanner(System.in);
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
		System.out.println("-----------CHOICE-----------");
		System.out.println("1.AddTrain\n2.ViewAllTrains\n3.ViewTrainByNumber");
		System.out.println("Enter the choice:");
		int choice=Integer.parseInt(s.nextLine());
		switch (choice) {
		case 1:
			System.out.println("How many Records");
			int n=Integer.parseInt(s.nextLine());
			for(int i=0;i<n;i++)
			{
			System.out.println("Enter the TrainNumber");
			long number=Long.parseLong(s.nextLine());
			System.out.println("Enter the TrainName");
			String name=s.nextLine();
			System.out.println("Enter the FirstStation");
			String fstation=s.nextLine();
			System.out.println("Enter the LastStation");
			String lstation=s.nextLine();
			System.out.println("Enter the Availability");
			String avail=s.nextLine();
			PreparedStatement ps=con.prepareStatement("insert into Train16 values(?,?,?,?,?)");
			ps.setLong(1,number);
			ps.setString(2,name);
			ps.setString(3,fstation);
			ps.setString(4,lstation);
			ps.setString(5,avail);
			int k=ps.executeUpdate();
			if(k>0)
			{
				System.out.println("Product details updated....");
			}
			}//end of loop
			break;
		case 2:
			PreparedStatement ps1=con.prepareStatement("select * from Train16");
			ResultSet rs=ps1.executeQuery();
			while(rs.next()){
				System.out.println(rs.getLong(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5));
			}//end of while
			break;
		case 3:
			System.out.println("Enter the TrainNumber");
			String code=s.nextLine();
			PreparedStatement ps2=con.prepareStatement("select * from Train16 where trainnumber=?");
			ps2.setString(1,code);
			ResultSet rs2=ps2.executeQuery();
			if(rs2.next()){
				System.out.println(rs2.getLong(1)+"\t"+rs2.getString(2)+"\t"+rs2.getString(3)+"\t"+rs2.getString(4)+"\t"+rs2.getString(5));
			}//end of if
			else {
				System.out.println("Invalid TrainNumber");
			}
			break;
		default:
			System.out.println("Invalid Option");
			break;
		}//End of switch
		con.close();
		s.close();
	}

}
