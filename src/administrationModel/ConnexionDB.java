package administrationModel;

import java.sql.*;

public class ConnexionDB {

	Connection con;
	Statement st;
	
	public Connection getCon() { return con; }

	public void setCon(Connection con) { this.con = con; }

	public Statement getSt() { return st; }

	public void setSt(Statement st) { this.st = st; }

	public ConnexionDB() throws SQLException
	{
		try {
			
			String username="sys as sysdba";
			String pswd="urwelcome";
			String host="jdbc:oracle:thin:@HayatMh:1521:xe";
			
			Class.forName("oracle.jdbc.driver.OracleDriver");  

			con=DriverManager.getConnection(host,username,pswd);  
			
			st=con.createStatement();

	}
	catch (ClassNotFoundException | SQLException err)	{ err.printStackTrace();; }
		
	}

	
	
}
