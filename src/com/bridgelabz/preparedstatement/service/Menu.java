package com.bridgelabz.preparedstatement.service;

import com.bridgelabz.utils.InputUtility;

public class Menu {
	private static PreparedStmtService service = new PreparedStmtServiceImpl();
	private static User user = new User();
	private static int choice;

	public static void menu() {
		do {
			System.out.println("1.Insert Record\n2.Delete Record\n3.Update Record\n4.Display all Records\n5.Exit");
			System.out.println("Enter Your Choice: ");
			choice = InputUtility.intVal();
			switch (choice) {
			case 1:
				if (service.insertRecord(insertRecord()))
					System.out.println("Record Inserted Successfully...!!!");
				else
					System.out.println("Error...while inserting record...");
				break;
			case 2:
				if (service.deleteRecord(deleteRecord()))
					System.out.println("Record Deleted Successfully...!!!");
				else
					System.out.println("Error...while Deleting record...");
				break;
			case 3:
				if (service.updateRecord(updateRecord()))
					System.out.println("Record Updated Successfully...!!!");
				else
					System.out.println("Error...while Updating record...");
				break;
			case 4:
				if (!service.displayRecord())
					System.out.println("No Records Found...!!!");
				break;
			case 5:
				System.out.println("Bye...!!!");
				break;

			default:
				System.out.println("Please Select Valid Choice...!!!");
				break;
			}
		} while (choice != 5);
	}

	private static User insertRecord() {
		System.out.println("Enter id: ");
		user.setId(InputUtility.intVal());

		System.out.println("Enter First Name: ");
		user.setName(InputUtility.stringVal());

		System.out.println("Enter Email Address: ");
		user.setEmail(InputUtility.stringVal());

		System.out.println("Enter Mobile Number: ");
		user.setMobile(InputUtility.longVal());
		return user;
	}

	private static User updateRecord() {
		System.out.println("Enter id for Update: ");
		int id = InputUtility.intVal();
		user.setId(id);
		if (id > 0) {
			System.out.println("Do you want to edit your name(Y/n):");
			if (InputUtility.stringVal().equalsIgnoreCase("y")) {
				System.out.println("Enter First Name: ");
				user.setName(InputUtility.stringVal());
			}
			System.out.println("Do you want to edit your email Address(Y/n):");
			if (InputUtility.stringVal().equalsIgnoreCase("y")) {
				System.out.println("Enter Email Address: ");
				user.setEmail(InputUtility.stringVal());
			}
			System.out.println("Do you want to edit your Mobile Number(Y/n):");
			if (InputUtility.stringVal().equalsIgnoreCase("y")) {
				System.out.println("Enter Mobile Number: ");
				user.setMobile(InputUtility.longVal());
			}
		}
		return user;
	}

	private static User deleteRecord() {
		System.out.println("Enter id for Delete User: ");
		int id = InputUtility.intVal();
		user.setId(id);
		return user;
	}
}
