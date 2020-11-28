package com.ravikantpractice.jdbc;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class app4 {

	public static void main(String[] args) {
		// update the table value
		Connection con=null;
		Statement st=null;
		Scanner scanner=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			st=con.createStatement();
			scanner=new Scanner(System.in);
			System.out.println("Bonus amount   ");
			int bonus=scanner.nextInt();
			System.out.println("salary Range   ");
			float salRange=scanner.nextFloat();
			int rowcount=st.executeUpdate("update emp1 set ESAL=ESAL +"+bonus+" where ESAL<"+salRange);
			System.out.println("employees updated: "+rowcount);
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
