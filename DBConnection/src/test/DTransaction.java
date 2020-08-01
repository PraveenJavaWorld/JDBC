package test;
import java.util.*;
import java.sql.*;
public class DTransaction {

	public static void main(String[] args)
	throws ClassNotFoundException,SQLException{
		Scanner s=new Scanner(System.in);
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
		PreparedStatement ps=con.prepareStatement("update bank16 set balance=balance+? where AccountNumber=?");
		PreparedStatement ps1=con.prepareStatement("select * from Bank16 where AccountNumber=?");
		con.setAutoCommit(false);
		Savepoint s1=con.setSavepoint();
		System.out.println("Enter the AccountNumber(Home)");
		long Accno1=Long.parseLong(s.nextLine());
		ps1.setLong(1,Accno1);
		ResultSet rs1=ps1.executeQuery();
		if(rs1.next())
		{
			float balance=rs1.getFloat(3);
			System.out.println("Enter the AccountNumber(Beneficiary)");
			long bAccno=Long.parseLong(s.nextLine());
			ps1.setLong(1,bAccno);
			ResultSet rs2=ps1.executeQuery();
			if(rs2.next()){
				System.out.println("Enter the Amount to be Transferred");
				float amount=Float.parseFloat(s.nextLine());
				if(amount<=balance)
				{
					ps.setFloat(1,-amount);
					ps.setLong(2,Accno1);
					int i=ps.executeUpdate();
					ps.setFloat(1,amount);
					ps.setLong(2,bAccno);
					int j=ps.executeUpdate();
					if(i==1 && j==1)
					{
						System.out.println("Transaction Completed...");
						con.commit();
					}//end of if
					else
					{
						System.out.println("Transaction Failed...");
						con.rollback(s1);
					}
				}//end of if
				else
				{
					System.out.println("Insufficient Funds...");
				}
			}//end of if
			else
			{
				System.out.println("Invalid Beneficiary Account Number...");
			}
		}//end of if
		else
		{
			System.out.println("Invalid Account Number(Home)");
		}
		con.close();
		s.close();

	}

}
