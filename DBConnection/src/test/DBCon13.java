package test;
import java.sql.*;
import java.util.*;
public class DBCon13 {

	public static void main(String[] args) 
	throws ClassNotFoundException,SQLException{
		Scanner s=new Scanner(System.in);
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
		System.out.println("-----CHOICE-----");
		System.out.println("1.User Registration\n2.User Login\n");
		System.out.println("Enter Your Choice");
		int choice=Integer.parseInt(s.nextLine());
		switch (choice) 
		{
		case 1:
			System.out.println("Enter Username");
			String uname=s.nextLine();
			System.out.println("Enter Password");
			String password=s.nextLine();
			System.out.println("Enter FirstName");
			String fname=s.nextLine();
			System.out.println("Enter LastName");
			String lname=s.nextLine();
			System.out.println("Enter City");
			String city=s.nextLine();
			System.out.println("Enter PhoneNumber");
			float pnumber=Float.parseFloat(s.nextLine());
			System.out.println("Enter MailID");
			String mailid=s.nextLine();
			PreparedStatement ps1=con.prepareStatement("insert into userreg16 values(?,?,?,?,?,?,?)");
			ps1.setString(1,uname);
			ps1.setString(2,password);
			ps1.setString(3,fname);
			ps1.setString(4,lname);
			ps1.setString(5,city);
			ps1.setFloat(6,pnumber);
			ps1.setString(7,mailid);
			int k=ps1.executeUpdate();
			if(k>0)
			{
				System.out.println("Records Updated...");
			}
			break;
		case 2:
			PreparedStatement ps8=con.prepareStatement("select * from Userreg16 where Username=? and Password=?");
			System.out.println("Enter the Username");
			ps8.setString(1,s.nextLine());
			System.out.println("Enter Password");
			ps8.setString(2,s.nextLine());
			ResultSet rs5=ps8.executeQuery();
			if(rs5.next())
			{
			System.out.println("-----------CHOICE-----------");
			System.out.println("1.AddBook\n2.ViewAllBooks\n3.ViewBookByCode\n4.UpdateBookPrice\n5.DeleteBookByCode");
			System.out.println("Enter the choice:");
			int choice1=Integer.parseInt(s.nextLine());
			switch (choice1)
			{
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
				PreparedStatement ps2=con.prepareStatement("insert into Book16 values(?,?,?,?,?)");
				ps2.setString(1,Code);
				ps2.setString(2,Name);
				ps2.setString(3,Author);
				ps2.setFloat(4,Price);
				ps2.setInt(5,Quantity);
				int k1=ps2.executeUpdate();
				if(k1>0)
				{
					System.out.println("Product details updated....");
				}
				}//end of for loop
				break;
			case 2:
				PreparedStatement ps3=con.prepareStatement("select * from Book16");
				ResultSet rs=ps3.executeQuery();
				while(rs.next())
				{
					System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getFloat(4)+"\t"+rs.getInt(5));
				}//end of while
				break;
			case 3:
				System.out.println("Enter the Book Code");
				String code=s.nextLine();
				PreparedStatement ps4=con.prepareStatement("select * from Book16 where code=?");
				ps4.setString(1,code);
				ResultSet rs2=ps4.executeQuery();
				if(rs2.next())
				{
					System.out.println(rs2.getString(1)+"\t"+rs2.getString(2)+"\t"+rs2.getString(3)+"\t"+rs2.getFloat(4)+"\t"+rs2.getInt(5));
				}//end of if
				else 
				{
					System.out.println("Invalid Code");
				}
				break;
			case 4:
				System.out.println("Enter the Book Code");
				String code1=s.nextLine();
				PreparedStatement ps5=con.prepareStatement("select * from Book16 where code=?");
				ps5.setString(1,code1);
				ResultSet rs3=ps5.executeQuery();
				if(rs3.next())
				{
					System.out.println(rs3.getString(1)+"\t"+rs3.getString(2)+"\t"+rs3.getString(3)+"\t"+rs3.getFloat(4)+"\t"+rs3.getInt(5));
					PreparedStatement ps6=con.prepareStatement("update book16 set price=? where code=?");
					System.out.println("Enter the New Price");
					ps6.setDouble(1,Double.parseDouble(s.nextLine()));
					ps6.setString(2,code1);
					int k2=ps6.executeUpdate();
					if(k2>0)
					{
						System.out.println("Price Updated...");
					}
				}//end of if
				else 
				{
				System.out.println("Invalid Book Code");
				}
				break;
			case 5:
				PreparedStatement ps6=con.prepareStatement("select * from book16 where code=?");
				System.out.println("Enter the Book Code");
				String code2=s.nextLine();
				ps6.setString(1,code2);
				ResultSet rs4=ps6.executeQuery();
				if(rs4.next())
				{
					PreparedStatement ps7=con.prepareStatement("delete from book16 where code=?");
					ps7.setString(1,code2);
					int k3=ps7.executeUpdate();
					if(k3>0)
					{
						System.out.println("Record Deleted...");
					}
				}//end of if
				else
				{
					System.out.println("Invalid Code");
				}
			}
			}//end of if
			else
			{
				System.out.println("Invalid Credentials");
			}
			break;
		default:
			System.out.println("Invalid Option");
		break;
		}//end of switch
		con.close();
		s.close();
	}

}
