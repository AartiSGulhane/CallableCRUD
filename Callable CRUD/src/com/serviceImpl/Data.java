package com.serviceImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.client.Test;
import com.services.Requirments;

public class Data implements Requirments {
	Scanner sc=new Scanner(System.in);

	@Override
	public void createTable() throws Exception {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			CallableStatement cs=con.prepareCall("{call createTable()}");
		
			cs.execute();
			System.out.println("Table created Successfully...");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void insertData() throws Exception {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			
			System.out.println("Enter Details...");
			
			System.out.println("Enter Rank Id");
			int rankid=sc.nextInt();
			System.out.println("Enter Name");
			String name=sc.next();
			System.out.println("Enter Country");
			String country=sc.next();
			System.out.println("Enter Sport");
			String sport=sc.next();
			System.out.println("Enter No Of Records ");
			int noofrecords=sc.nextInt();
			System.out.println("Enter No of Trophies");
			int nooftrophies=sc.nextInt();
			System.out.println("Enter Total Income");
			int totalincome=sc.nextInt();
			
			CallableStatement cs=con.prepareCall("{ call insertData(?,?,?,?,?,?,?)}");
			cs.setInt(1,rankid);
			cs.setString(2,name);
			cs.setString(3,country);
			cs.setString(4,sport);
			cs.setInt(5,noofrecords);
			cs.setInt(6,nooftrophies);
			cs.setInt(7,totalincome);
			
			
			System.out.println(cs.execute());
			System.out.println("Data inserted successfully...");
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void viewSingleData() throws Exception {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			System.out.println("Enter Rank Id to view Data");
			int rankid=sc.nextInt();
			
			CallableStatement cs=con.prepareCall("{call viewSingleData(?)}");
			cs.setInt(1, rankid);
			ResultSet rs=cs.executeQuery();
			while(rs.next())
			{
				System.out.println("Rank Id = "+rs.getInt(1));
				System.out.println("Name = "+rs.getString(2));
				System.out.println("Country = "+rs.getString(3));
				System.out.println("Sports = "+rs.getString(4));
				System.out.println("No of Records = "+rs.getInt(5));
				System.out.println("No of Trophies = "+rs.getInt(6));
				System.out.println("Total Income = "+rs.getInt(7));
			}
			
			
			System.out.println("Details of Rank Id"+rankid);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void viewAllData() throws Exception {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			CallableStatement cs=con.prepareCall("{call viewAllData()}");
			System.out.println("All Players Details..");
			ResultSet rs=cs.executeQuery();
			while(rs.next())
			{
				System.out.println("Rank Id = "+rs.getInt(1));
				System.out.println("Name = "+rs.getString(2));
				System.out.println("Country = "+rs.getString(3));
				System.out.println("Sports = "+rs.getString(4));
				System.out.println("No of Records = "+rs.getInt(5));
				System.out.println("No of Trophies = "+rs.getInt(6));
				System.out.println("Total Income = "+rs.getInt(7));
			
			}
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void updateData() throws Exception {
		 
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
					
					System.out.println("Enter Rank Id to update the Record");
					int rankid=sc.nextInt();
					
					
					boolean b= true;
					while(b)
				{
						System.out.println("Select the field you want to update");
						System.out.println("1.Name\n"+
										   "2. Country\n"+
						                   "3. Sport\n"+
						                   "4. No of Records\n"+
						                   "5. No of Trophies\n"+
						                   "6. Total Income\n"+
						                   "7. Exit");
						int choice=sc.nextInt();
						try
					{
							switch(choice)
							{
							case 1:{
								System.out.println("Enter Name to update");
									String name=sc.next();
									CallableStatement cs=con.prepareCall("{call updateName(?,?)}");
									cs.setInt(1,rankid);
									cs.setString(2, name);
									cs.executeUpdate();
									break;
									
									}
							case 2:{
								System.out.println("Enter Country to update");
								String country=sc.next();
								CallableStatement cs=con.prepareCall("{call updateCountry(?,?)}");
								cs.setInt(1,rankid);
								cs.setString(3, country);
								cs.executeUpdate();
								break;
								
							}
							case 3:{
								System.out.println("Enter Sport to update ");
								String sport=sc.next();
								CallableStatement cs=con.prepareCall("{call updateSport(?,?)}");
								cs.setInt(1,rankid);
								cs.setString(4, sport);
								cs.executeUpdate();
								break;
										
								}
							case 4:{
								System.out.println("Enter No of Records to update");
								int noofrecords=sc.nextInt();
								CallableStatement cs=con.prepareCall("{call updateNoOfRecords(?,?)}");
								cs.setInt(1,rankid);
								cs.setInt(4, noofrecords);
								cs.executeUpdate();
								break;
										
								}
							case 5:{
								System.out.println("Enter No of Trophies to update");
								int nooftrophies=sc.nextInt();
								CallableStatement cs=con.prepareCall("{call updateNoOfTrophies(?,?)}");
								cs.setInt(1,rankid);
								cs.setInt(5, nooftrophies);
								cs.executeUpdate();
								break;
										
								}
							case 6:{
								System.out.println("Enter Total Income to update");
								int totalincome=sc.nextInt();
								CallableStatement cs=con.prepareCall("{call updatetotalIncome(?,?)}");
								cs.setInt(1,rankid);
								cs.setInt(6, totalincome);
								cs.executeUpdate();
								break;
										
								}
							case 7:
							{
								Test.mainMenu();
							}
						default:
						{
							System.out.println("Invalid choice");
						}
						}
				}
						catch(Exception e)
						{
							System.out.println("Error occured");
						}
						
					
					}
					b=false;
				}
					
				 catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				}
			
	}

	@Override
	public void deleteSingleData() throws Exception {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			System.out.println("Enter Rank Id to delete the the Record");
			int rankid=sc.nextInt();
			
			CallableStatement cs=con.prepareCall("{call deleteSingleData(?)}");
			cs.setInt(1, rankid);
			cs.execute();
			System.out.println("Record of Rank Id "+rankid+" is deleted");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deleteAllData() throws Exception {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			CallableStatement cs=con.prepareCall("{call deleteAllData()}");
			cs.execute();
			System.out.println("All Data deleted..");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteTable() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		CallableStatement cs=con.prepareCall("{call deleteTable()}");
		cs.execute();
		System.out.println("Table deleted successfully..");
		
	}

}
