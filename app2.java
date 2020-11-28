package com.ravikantpractice.jdbc;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class app2 {

	public static void main(String[] args) throws Exception{
		// create table of database from here all dynamically
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","manager");
		Statement st=con.createStatement();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Table Name  :");
		String tname=br.readLine();
		String query= "create table "+tname+"(";
		String PrimaryKey="";
		int PrimaryKeyCount=0;
		while(true)
		{
			System.out.print("Column name   :");
			String colName=br.readLine();
			System.out.print("Column Datatype");
			String colType=br.readLine();
			System.out.print("column size");
			int colSize=Integer.parseInt(br.readLine());
			query=query + colName + " " + colType+ "("+colSize+")";
			System.out.print("IS primary key[yes/no]?:");
			String primarykeyoption=br.readLine();
			if(primarykeyoption.equalsIgnoreCase("yes"))
			{
				if(PrimaryKeyCount==0)
				{
					PrimaryKey=PrimaryKey+colName;
					PrimaryKeyCount=PrimaryKeyCount +1;
				}
				else
				{
					PrimaryKey=PrimaryKey + "," + colName;
				}
			}
			System.out.println("one more column[yes/no]?");
			String columnOption = br.readLine();
			if(columnOption.equalsIgnoreCase("yes"))
					{
				     query=query+",";
				     continue;
					}
			else
			{
				query=query+","+" primary key("+PrimaryKey+"))";
				break;
			}
			
		}
		//System.out.println(query);
		st.executeUpdate(query);
		System.out.println("Table "+tname+" is created successfully");
		st.close();
		con.close();

	}

}
