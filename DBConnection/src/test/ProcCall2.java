package test;
import java.util.*;
import java.sql.*;
public class ProcCall2 {

	public static void main(String[] args) 
	throws ClassNotFoundException,SQLException{
		Scanner s=new Scanner(System.in);
		float totalsal;
		float incsal;
		System.out.println("Enter the Employee ID");
		String id=s.nextLine();
		System.out.println("Enter the Name");
		String name=s.nextLine();
		System.out.println("Enter the Designation");
		String desig=s.nextLine();
		System.out.println("Enter the DateOfBirth");
		String dob=s.nextLine();
		System.out.println("Enter the DateOfJoining");
		String doj=s.nextLine();
		System.out.println("Enter the HouseNumber");
		String hno=s.nextLine();
		System.out.println("Enter the StreetName");
		String stname=s.nextLine();
		System.out.println("Enter the Pincode");
		long pincode=Long.parseLong(s.nextLine());
		System.out.println("Enter the PhoneNumber");
		long phoneno=Long.parseLong(s.nextLine());
		System.out.println("Enter the Mail ID");
		String mailid=s.nextLine();
		System.out.println("Enter the BasicSalary");
		float bsal=Float.parseFloat(s.nextLine());
		totalsal=bsal+(0.92f*bsal)+(0.62f*bsal);
		incsal=totalsal+(0.23f*bsal);
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
		CallableStatement cs=con.prepareCall("{call EmployeeDetails16(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		cs.setString(1,id);
		cs.setString(2,name);
		cs.setString(3,desig);
		cs.setString(4,dob);
		cs.setString(5,doj);
		cs.setString(6,hno);
		cs.setString(7,stname);
		cs.setLong(8,pincode);
		cs.setLong(9,phoneno);
		cs.setString(10,mailid);
		cs.setFloat(11,bsal);
		cs.setFloat(12,totalsal);
		cs.setFloat(13,incsal);
		boolean k=cs.execute();
		if(k)
		{
			System.out.println("Employee Details Registered Successfully");
		}
		con.close();
		s.close();
				

	}

}
