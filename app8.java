package com.ravikantpractice.jdbc;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class app8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			st=con.createStatement();
			boolean b=st.execute("select * from emp1");
			System.out.println(b);
			rs=st.getResultSet();
			System.out.println("ENO\tENAME\tESAL\tEADD");
			System.out.println("----------------------");
			while(rs.next())
			{
				System.out.print(rs.getInt("ENO")+"\t");
				System.out.print(rs.getString("ENAME")+"\t");
				System.out.print(rs.getFloat("ESAL")+"\t");
				System.out.print(rs.getString("EADDR")+"\n");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
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

