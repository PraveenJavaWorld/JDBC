package test;
import java.sql.*;
import java.util.*;
public class DBCon8 {

	public static void main(String[] args) 
	throws ClassNotFoundException,SQLException{
		Scanner s=new Scanner(System.in);
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
		System.out.println("-----------CHOICE-----------");
		System.out.println("1.AddBook\n2.ViewAllBooks\n3.ViewBookByCode");
		System.out.println("Enter the choice:");
		int choice=Integer.parseInt(s.nextLine());
		switch (choice) {
		case 1:
			System.out.println("How many Records");
			int n=Integer.parseInt(s.nextLine());
			for(int i=0;i<n;i++)
			{
			System.out.println("Enter the Book Code");
			String Code=s.nextLine();
			System.out.println("Enter the Book Name");
			String Name=s.nextLine();
			System.out.println("Enter the Author");
			String Author=s.nextLine();
			System.out.println("Enter the Price");
			float Price=Float.parseFloat(s.nextLine());
			System.out.println("Enter the Quantity");
			int Quantity=Integer.parseInt(s.nextLine());
			PreparedStatement ps=con.prepareStatement("insert into Book16 values(?,?,?,?,?)");
			ps.setString(1,Code);
			ps.setString(2,Name);
			ps.setString(3,Author);
			ps.setFloat(4,Price);
			ps.setInt(5,Quantity);
			int k=ps.executeUpdate();
			if(k>0)
			{
				System.out.println("Product details updated....");
			}
			}//end of for loop
			break;
		case 2:
			PreparedStatement ps1=con.prepareStatement("select * from Book16");
			ResultSet rs=ps1.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getFloat(4)+"\t"+rs.getInt(5));
			}//end of while
			break;
		case 3:
			System.out.println("Enter the Code");
			String code=s.nextLine();
			PreparedStatement ps2=con.prepareStatement("select * from Book16 where code=?");
			ps2.setString(1,code);
			ResultSet rs2=ps2.executeQuery();
			if(rs2.next()){
				System.out.println(rs2.getString(1)+"\t"+rs2.getString(2)+"\t"+rs2.getString(3)+"\t"+rs2.getFloat(4)+"\t"+rs2.getInt(5));
			}//end of if
			else {
				System.out.println("Invalid Code");
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
