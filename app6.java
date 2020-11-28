package com.ravikantpractice.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class app6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con=null;
		Statement st=null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			st=con.createStatement();
			int rowcount=st.executeUpdate("create table emp10(eno number(3) primary key,ename varchar2(34),esal float(5),eaddr varchar2(20))");
			System.out.println(rowcount);
			int rowcount1=st.executeUpdate("drop table emp10");
			System.out.println(rowcount1);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				
				st.close();
				con.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		



	}

}

