package com.abc.jeevika.persistency;

import java.io.IOException;

import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertApp {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//JDBCAPI required parameters
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		//To connect with DB Engine using url,userName,password
		String url="jdbc:mysql:///Students";
		String userName="root";
		String password="root@123";
		
		//To get the query for execution from user
		
		
		try {
			//Establishing the connection with DB
			connection=DriverManager.getConnection(url,userName,password);
			if(connection!=null){
				String sqlInsertQuery="insert into Employees (E_name,Sal,DNO) values(?,?,?)";
				//Creating a preparedStatement to get the pre-compiled query object from DBE
				pstmt=connection.prepareStatement(sqlInsertQuery);
				if(pstmt!=null) {
					Scanner scan=new Scanner(System.in);
					while(true) {
						System.out.println("Enter your Student Id:: ");
						int id=scan.nextInt();
					
						System.out.println("Enter your Student Name:: ");
						String name=scan.next();
					
						System.out.println("Enter your Student Salary:: ");
						Float Sal=scan.nextFloat();
					
						System.out.println("Enter your Student DNO:: ");
						int DNO=scan.nextInt();
					//name="'"+name+"'";
					
					//String sqlInsertQuery="Insert into Student values("+id+","+name+","+age+","+marks+")";
					pstmt.setString(1,name);
					pstmt.setFloat(2,Sal);
					pstmt.setInt(3,DNO);
					
					int rowAffected=pstmt.executeUpdate();
					
						System.out.println("inserted into table..."+rowAffected);
						System.out.println("Do u want to insert one more record[YES/NO]");
						String option = scan.next();
						if(option.equalsIgnoreCase("No"))
							break;
					}
				}
				
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				}catch(SQLException ex) {
					ex.printStackTrace();
				}
			}
			if(connection!=null) {
				try {
					connection.close();
				}catch(SQLException ex) {
					ex.printStackTrace();
				}
			}
		}
	}

}
