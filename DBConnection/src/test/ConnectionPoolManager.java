package test;
import java.util.*;
import java.sql.*;
public class ConnectionPoolManager 
	{
	String databaseURL = "jdbc:oracle:thin:@localhost:1521:xe";
	String Username = "system";
	String Password = "1234";
	@SuppressWarnings("rawtypes")
	Vector pool=new Vector();//JCF Object
	
	public ConnectionPoolManager(){
		initialize();
	}
	
	private void initialize(){
		initializeConnectionPool();
	}
	
	
	@SuppressWarnings("unchecked")
	private void initializeConnectionPool(){
		while(!CheckIfConnectionPoolIsFull()){
			System.out.println("Connection Pool is Not Full...");
			pool.addElement(CreateNewConnectionForPool());
		}
		System.out.println("Connection Pool is Full...");
	}

	private boolean CheckIfConnectionPoolIsFull() {
		final int MAX_POOL_SIZE=5;
		//Check if the Pool Size
		if(pool.size()<MAX_POOL_SIZE){
			return false;
		}
		return true;
	}
	

	//Creating the Connection
	private Connection CreateNewConnectionForPool() {
		Connection connection=null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection=DriverManager.getConnection(databaseURL,Username,Password);
			System.out.println("Connection:"+connection);
		}
		catch (SQLException sqle) {
			System.err.println("SQL Exception:"+sqle);
		return null;
		}
		catch (ClassNotFoundException cnfe) {
			System.err.println("ClassNotFound Exception:"+cnfe);
			return null;
		}
		return connection;
	}
	
	public synchronized Connection
	getConnectionFromPool(){
		Connection connection=null;
		if(pool.size()>0){
			connection=(Connection)pool.firstElement();
			pool.removeElementAt(0);
		}
		return connection;
		}
	@SuppressWarnings("unchecked")
	public synchronized void returnConnectionToPool(Connection connection){
		pool.addElement(connection);
	}

	public static void main(String[] args) 
	throws SQLException{
		ConnectionPoolManager cpm=new ConnectionPoolManager();
		Connection con=cpm.getConnectionFromPool();
		PreparedStatement ps=con.prepareStatement("select * from Product16");
		System.out.println("Dis using Connection:"+con);
		System.out.println("Size of Connection Pool:"+cpm.pool.size());
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+rs.getInt(4));
		}//end of while
		cpm.returnConnectionToPool(con);
		System.out.println("Size of Connection Pool:"+cpm.pool.size());
		

	}

}
