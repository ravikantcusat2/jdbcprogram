package com.ravikantpractice.jdbc;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class app9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con=null;
		Statement st=null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			st=con.createStatement();
			boolean b=st.execute("update emp1 set ESAL=ESAL+500 WHERE ESAL<10000");
			System.out.println(b);
			int rowcount=st.getUpdateCount();
			System.out.println("records updated: "+rowcount);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				st.close();
				con.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}

	}

}
