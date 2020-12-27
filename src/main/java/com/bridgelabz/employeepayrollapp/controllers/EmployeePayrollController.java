package com.bridgelabz.employeepayrollapp.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.services.IEmployeePayrollService;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

	@Autowired
	private IEmployeePayrollService employeePayrollService;

	@GetMapping(value = { "", "/", "/get" })
	public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
		List<EmployeePayrollData> employeeDataList = null;
		employeeDataList = employeePayrollService.getEmployeePayrollData();
		ResponseDTO responseDTO = new ResponseDTO("Get Call Successfull", employeeDataList);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@GetMapping("/get/{empId}")
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId) {
		EmployeePayrollData employeeData = null;
		employeeData = employeePayrollService.getEmployeePayrollDataById(empId);
		ResponseDTO responseDTO = new ResponseDTO("Get Call for ID Successfull", employeeData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addEmployeePayrollData(
			@Valid @RequestBody EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData employeeData = null;
		employeeData = employeePayrollService.createEmployeePayrollData(employeePayrollDTO);
		ResponseDTO responseDTO = new ResponseDTO("Created Employee Payroll Data Successfully", employeeData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@PutMapping("/update/{empId}")
	public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empId") int empId,
			@Valid @RequestBody EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData employeeData = null;
		employeeData = employeePayrollService.updateEmployeePayrollData(empId, employeePayrollDTO);
		ResponseDTO responseDTO = new ResponseDTO("Updated Employee Payroll Data Successfully", employeeData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
		employeePayrollService.deleteEmployeePayrolllData(empId);
		ResponseDTO responseDTO = new ResponseDTO("Deleted Employee Payroll Data Successfully",
				"Deleted id : " + empId);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
}