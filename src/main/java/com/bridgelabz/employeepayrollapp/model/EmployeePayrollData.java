package com.bridgelabz.employeepayrollapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;

@Entity
@Table(name = "EMPLOYEE")
public class EmployeePayrollData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeId;

	private String name;
	private long salary;

	public EmployeePayrollData() {
	}

	public EmployeePayrollData(int id, EmployeePayrollDTO employeePayrollDTO) {
		this.employeeId = id;
		this.name = employeePayrollDTO.getName();
		this.salary = employeePayrollDTO.getSalary();
	}

	public EmployeePayrollData(String name, long salary) {
		this.name = name;
		this.salary = salary;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}
}