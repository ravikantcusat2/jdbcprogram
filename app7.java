package com.ravikantpractice.jdbc;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class app7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			st=con.createStatement();
			rs=st.executeQuery("select * from emp1");
			System.out.println("ENO\tENAME\tESAL\tEADD");
			System.out.println("----------------------");
			while(rs.next())
			{
				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getFloat(3)+"\t");
				System.out.print(rs.getString(4)+"\n");
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
