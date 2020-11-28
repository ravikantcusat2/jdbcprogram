package com.ravikantpractice.jdbc;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class app1 {

	public static void main(String[] args) throws Exception {
		//create table from here to databasee
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","manager");
		Statement st=con.createStatement();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Table Name  :");
		String tname=br.readLine();
		String query= "create table "+tname+"(ENO number(30) primary key, Ename varchar2(10),Esal float(5), EADDR varchar2(10))";
		st.executeUpdate(query);
		System.out.println("Table "+tname+" is created successfully");
		st.close();
		con.close();
		

	}

}

