package com.bridgelabz.employeepayrollapp.dto;

import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

import lombok.Data;

@Data
public class EmployeePayrollDTO {

	private String name;
	private long salary;

	public EmployeePayrollDTO(EmployeePayrollData employeePayroll) {
		this.setName(employeePayroll.getName());
		this.setSalary(employeePayroll.getSalary());
	}

	public EmployeePayrollDTO() {

	}

}