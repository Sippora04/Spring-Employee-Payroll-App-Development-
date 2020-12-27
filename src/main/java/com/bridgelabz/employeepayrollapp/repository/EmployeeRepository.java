package com.bridgelabz.employeepayrollapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeePayrollData, Integer> {

}