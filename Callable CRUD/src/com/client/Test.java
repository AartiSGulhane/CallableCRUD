package com.client;

import java.util.Scanner;

import com.serviceImpl.Data;

public class Test {

	public static void mainMenu() {
	Data r=new Data();
	Scanner sc=new Scanner(System.in);

	while(true)
	{

		try {
		System.out.println("Enter your choice");
		System.out.println("1. To create table\n"+
				"2. To Insert Data\n"+
				"3. To View Single Data\n"+
				"4. To View All Data\n"+
				"5. To Update Data\n"+
				"6. To Delete Single Data\n"+
				"7. To Delete All Data\n"+
				"8. To Delete Table\n"+
				"9. To Exit");

			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:{
				r.createTable();
				break;
			}
			case 2:{
				r.insertData();
				break;
			}
			case 3:{
				r.viewSingleData();
				break;
			}
			case 4:{
				r.viewAllData();
				break;
			}
			case 5:{
				r.updateData();
				break;
			}
			case 6:{
				r.deleteSingleData();
				break;
			}
			case 7:{
				r.deleteAllData();
				break;
			}
			case 8:{
				r.deleteTable();
				break;
			}
			case 9:{
				System.exit(0);
			}
			default :
			{
				System.out.println("Enter Valid Input");
			}
			}
		}
		catch(Exception e)
		{
			System.out.println("Error occured");
		}
	}

}

public static void main(String[] args) throws Exception {

	mainMenu();
}

}
