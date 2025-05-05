package com.tp.practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class CreateDBUsingJDBC {

	public static void main(String[] args) throws SQLException {
	  
		String url ="jdbc:Mysql://localhost:3306/";
		String un = "root" ,pswd ="root";
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection connect = DriverManager.getConnection(url,un,pswd);
		Statement stmt = connect.createStatement();
		//boolean s = stmt.execute("create database vTigerDB");
		stmt.execute("use vTigerDB");
		
		boolean result = stmt.execute("create table vTigerContactss(name varchar(20),phone varchar(14),address varchar(50))");
		System.out.println("table created: "+result);
		
		stmt.executeUpdate("insert into vTiger_Contact values('gowsi','9789035637','bangalore')");
		System.out.println("inserted: "+result);
		
		
		
		 
		
	}

}
