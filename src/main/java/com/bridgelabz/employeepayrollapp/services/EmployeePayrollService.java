package com.bridgelabz.employeepayrollapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

@Service
public class EmployeePayrollService implements IEmployeePayrollService{

	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		List<EmployeePayrollData> employeeDataList = new ArrayList<>();
		employeeDataList.add(new EmployeePayrollData(1, new EmployeePayrollDTO("Sippora",50000)));
		return employeeDataList;
	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int empId) {
		EmployeePayrollData employeeData= null;
		employeeData = new EmployeePayrollData(empId, new EmployeePayrollDTO("Sippora",50000));
		return employeeData;
	}

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData employeeData= null;
		employeeData = new EmployeePayrollData(1, employeePayrollDTO);
		return employeeData;
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData employeeData = null;
		employeeData = new EmployeePayrollData(empId, employeePayrollDTO);
		return employeeData;
	}

	@Override
	public void deleteEmployeePayrolllData(int empId) {		
	}

	
}