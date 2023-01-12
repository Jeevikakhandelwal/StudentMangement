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

public class DeleteApplication {
	public static final String sqlInsertQuery="delete from employees where E_id=?";
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
		
		try {
			//Establishing the connection with DB
			connection=DriverManager.getConnection(url,userName,password);
			if(connection!=null){
				
				//Creating a preparedStatement to get the pre-compiled query object from DBE
				pstmt=connection.prepareStatement(sqlInsertQuery);
				if(pstmt!=null) {
					Scanner scan=new Scanner(System.in);
					System.out.print("Enter the id to be deleted from a table:: ");
					int id=scan.nextInt();
					
					pstmt.setInt(1,id);
					int rowAffected=pstmt.executeUpdate();
					
						System.out.println("deleted record from table..."+rowAffected);	
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
