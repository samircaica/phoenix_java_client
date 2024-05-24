import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Random;

public class TestClientThin {

	public static void main(String[] args) throws SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;

		String phoenix_host = args[0];
		String phoenix_port = args[1];
		String phoenix_auth = args[2];
		String phoenix_serialization = args[3];
		String phoenix_principal = "";
		String phoenix_keytab = "";

		String[] depts = {"SALES", "SUPPORT", "DEVELOPMENT", "MANAGEMENT"};

		if(phoenix_auth.equals("SPNEGO")) {
			phoenix_principal = args[4];
			phoenix_keytab = args[5];
			con = DriverManager.getConnection("jdbc:phoenix:thin:url="+phoenix_host+":"+phoenix_port+";authentication=SPNEGO;serialization="+phoenix_serialization+";principal="+phoenix_principal+";keytab="+phoenix_keytab);
			stmt = con.createStatement();
		} else {
			con = DriverManager.getConnection("jdbc:phoenix:thin:url="+phoenix_host+":"+phoenix_port+";authentication=BASIC;serialization="+phoenix_serialization);
			stmt = con.createStatement();
		}
		
		
		System.out.println("Using to connect = " + phoenix_host + ", " + phoenix_port+ ", " +phoenix_auth+ ","+phoenix_serialization+ ", "+phoenix_principal+ ", " + phoenix_keytab);

		stmt.executeUpdate("DROP TABLE IF EXISTS EMP4");
		stmt.executeUpdate("CREATE TABLE EMP4 (emp_id integer not null, dept char(15) constraint PK PRIMARY KEY(EMP_ID))");
		Random r = new Random();
        
		for(int i=0;i<10;i++) {
			int randomNumber = r.nextInt(depts.length);
			String deptsValue = depts[randomNumber];
			
			int j = i+1;
			stmt.executeUpdate("UPSERT INTO EMP4 VALUES ("+j+",'"+deptsValue+"')");
		}
		
		con.commit();
		
		PreparedStatement statement = con.prepareStatement("select * from EMP4");
		rset = statement.executeQuery();
		System.out.println("emp_id dept");
		while (rset.next()) {
			System.out.println(rset.getString("emp_id")+" "+rset.getString("dept"));
		}
		statement.close();
		con.close();
	}
}