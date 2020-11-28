package com.ravikantpractice.jdbc;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class app3 {

	public static void main(String[] args) {
		// insert records from here to database
		Connection con=null;
		Statement st=null;
		BufferedReader br=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			st=con.createStatement();
			br=new BufferedReader(new InputStreamReader(System.in));
			while(true)
			{
				System.out.println("Employee number");
				int eno=Integer.parseInt(br.readLine());
				System.out.println("Employee name");
				String ename=br.readLine();
				System.out.println("Employee salary");
				Float esal=Float.parseFloat(br.readLine());
				System.out.println("Employee Address");
				String addr=br.readLine();
				String query="insert into emp1 values("+eno+",'"+ename+"',"+esal+",'"+addr+"')";
				st.executeUpdate(query);
				System.out.println("employee inserted successfully");
				System.out.println("one more entry[yes/no]");
				String option=br.readLine();
				if(option.equalsIgnoreCase("yes"))
				{
					continue;
				}
				else
				{
					break;
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			try {
				br.close();
				st.close();
				con.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
				
