package com.uiFrameworkk.pentland.helper.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApplicationDBQuery {

	public int getEmpSalary(int empId) throws NumberFormatException, SQLException {
		int salary = 0;
		String dbQuery = "SELECT salary FROM person.employee where idemployee=" + empId;
		ResultSet result = DataBaseHelper.getResultSet(dbQuery);
		while (result.next()) {
			salary = Integer.parseInt(result.getString("salary"));
		}
		return salary;

	}

	public List<Employee> getEmployee() throws SQLException {
		List<Employee> data = new ArrayList<Employee>();
		String dbQuery = "SELECT * FROM person.employee";
		ResultSet result = DataBaseHelper.getResultSet(dbQuery);
		while (result.next()) {
			Employee emp = new Employee();
			emp.setEmpId(Integer.parseInt(result.getString("idemployee")));
			emp.setSalary(Integer.parseInt(result.getString("salary")));
			emp.setName(result.getString("name"));
			emp.setAddress(result.getString("address"));
			
			data.add(emp);
		}
		return data;

	}

	public static void main(String[] args) throws NumberFormatException, SQLException {
		ApplicationDBQuery applicationDBQuery = new ApplicationDBQuery();
		int salary = applicationDBQuery.getEmpSalary(2);
		System.out.println(salary);
		List<Employee> listoFData = applicationDBQuery.getEmployee();
		for (Employee data : listoFData) {
		System.out.println("empID is : " + data.getEmpId() + "emp salary is :" + data.getSalary() + "emp name is :"
					+ data.getName() + "emp Address is :" + data.getAddress());
		}
	}

}
