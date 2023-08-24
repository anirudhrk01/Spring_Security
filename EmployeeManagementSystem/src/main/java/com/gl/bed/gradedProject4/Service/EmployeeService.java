package com.gl.bed.gradedProject4.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort.Direction;

import com.gl.bed.gradedProject4.Entity.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);

	void deleteEmployeeById(Long empId);

	Optional<Employee> updateEmployee(Employee employee);

	Optional<Employee> fetchEmployeeById(Long empId);

	List<Employee> fetchAllEmployee();

	List<Employee> searchEmployeeByFirstName(String firstName);

	List<Employee> getListOfEmployeesSortedByFirstName(Direction order);
}
