package com.gl.bed.gradedProject4.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.gl.bed.gradedProject4.Entity.Employee;
import com.gl.bed.gradedProject4.Repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public Employee saveEmployee(Employee employee) {
		return this.employeeRepository.save(employee);
	}

	public void deleteEmployeeById(Long empId) {
		this.employeeRepository.deleteById(empId);
	}

	public Optional<Employee> updateEmployee(Employee employee) {
		return this.employeeRepository.findById(employee.getEmpid());

	}

	public Optional<Employee> fetchEmployeeById(Long empId) {
		return this.employeeRepository.findById(empId);
	}

	public List<Employee> fetchAllEmployee() {
		return this.employeeRepository.findAll();
	}

	@Override
	public List<Employee> searchEmployeeByFirstName(String firstName) {
		Employee employee = new Employee();
		employee.setEmpfirstname(firstName);
		ExampleMatcher matcher = ExampleMatcher.matching()
				.withMatcher("emp_firstname", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("emp_lastname", "emp_id", "emp_email");
		Example<Employee> example = Example.of(employee, matcher);
		return this.employeeRepository.findAll(example);

	}

	@Override
	public List<Employee> getListOfEmployeesSortedByFirstName(Direction order) {
		List<Employee> employees = employeeRepository.findAll(Sort.by(order, "empfirstname"));
		return employees;
	}

}
