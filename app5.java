package com.ravikantpractice.jdbc;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class app5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con=null;
		Statement st=null;
		Scanner scanner=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			st=con.createStatement();
			scanner=new Scanner(System.in);
			System.out.println("salary range");
			float salRange=scanner.nextFloat();
			int rowcount=st.executeUpdate("delete from emp1 where ESAL<"+salRange);
			System.out.println("no of employees deleted "+rowcount);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				scanner.close();
				st.close();
				con.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		


	}

}
