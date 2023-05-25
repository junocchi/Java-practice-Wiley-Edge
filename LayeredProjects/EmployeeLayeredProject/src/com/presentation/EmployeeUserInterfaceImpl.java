package com.presentation;

import java.util.LinkedList;
import java.util.Scanner;

import com.dto.Employee;
import com.service.EmployeeBusinessLogic;
import com.service.EmployeeBusinessLogicImpl;

public class EmployeeUserInterfaceImpl implements EmployeeUserInterface {

	private EmployeeBusinessLogic bussinessLogic=new EmployeeBusinessLogicImpl();
	
	@Override
	public void showMenu() {
		System.out.println("1. List All Employees");
		System.out.println("2. Add New Employee");
		System.out.println("3. Delete Existing Employee");
		System.out.println("4. Search for Employee by ID");
		System.out.println("5. Exit");

	}

	@Override
	public void performMenu(int choice) {
		Scanner scanner=new Scanner(System.in);
		switch (choice) {
		case 1: 
			LinkedList<Employee> employees=bussinessLogic.getAllEmployees();
			for(Employee employee:employees) {
				System.out.println(employee);
			}
			break;
		case 2:
			Employee employee=new Employee();
			System.out.println("Enter Employee ID : ");
			employee.setEmpId(scanner.nextInt());
			System.out.println("Enter Employee Name : ");
			employee.setEmpName(scanner.next());
			System.out.println("Enter Employee Designation : ");
			employee.setEmpDesignation(scanner.next());
			System.out.println("Enter Employee Department : ");
			employee.setEmpDepartment(scanner.next());
			System.out.println("Enter Employee Salary : ");
			employee.setEmpSalary(scanner.nextDouble());
			
			boolean status=bussinessLogic.addEmployee(employee);
			
			if(status)
				System.out.println("Employee Added!");
			else
				System.out.println("Employee Not Added!");
			break;
		case 3:
			System.out.println("Enter Employee ID whoes record you want to delete : ");
			int id=scanner.nextInt();
			if(bussinessLogic.deleteEmployee(id))
				System.out.println("Record Deleted");
			else
				System.out.println("Employee with id "+id+" does not exist");
			break;
		case 4:
			//write logic to search for employee by ID and display
			System.out.println("Enter Employee ID number: ");
		    int idNum = scanner.nextInt();
		    String employeeName = bussinessLogic.findEmployeeNameById(idNum);
		    if (employeeName != null) {
		        System.out.println("Search result: " + employeeName);
		    } else {
		        System.out.println("Employee not found for ID number: " + idNum);
		    }
		    break;
			
		case 5:
			bussinessLogic.saveAllEmployees();
			System.out.println("Thanks for Using Employee Management System");
			System.exit(0);
		default:
			System.out.println("Invalid Choice");
		}

	}

}