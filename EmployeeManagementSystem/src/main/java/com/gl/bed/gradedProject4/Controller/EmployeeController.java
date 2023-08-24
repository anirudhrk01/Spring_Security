package com.gl.bed.gradedProject4.Controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gl.bed.gradedProject4.Entity.Employee;
import com.gl.bed.gradedProject4.Service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/list")
	public List<Employee> getAllEmployeesEmps() {
		List<Employee> emp = employeeService.fetchAllEmployee();
		return emp;
	}

	@GetMapping("/{empid}")
	public Optional<Employee> getEmployeesbyid(@PathVariable("empid") Long empId) {
		return employeeService.fetchEmployeeById(empId);

	}

	@PostMapping("/add")
	public Employee save(String emp_firstname, String emp_lastname, String emp_email) {
		Employee employee = new Employee();
		employee.setEmpfirstname(emp_firstname);
		employee.setEmplastname(emp_lastname);
		employee.setEmpemail(emp_email);
		return employeeService.saveEmployee(employee);
	}

	@PutMapping("/update")
	public Optional<Employee> updateEmployee(Employee employee) {
		return employeeService.updateEmployee(employee);
	}

	@DeleteMapping("/delete/{empid}")
	public String deleteEmployee(@PathVariable("empid") Long empid) {
		Employee employee = null;
		Optional<Employee> result = employeeService.fetchEmployeeById(empid);
		if (result.isPresent()) {
			employee = result.get();
		}
		if (employee != null) {
			employeeService.deleteEmployeeById(empid);
			return "Deleted employee id : " + empid;
		} else {
			return "Employee record not exist in database with Id : " + empid;
		}

	}

	@GetMapping("/search/{empFistName}")
	public List<Employee> searchEmployeeByFirstName(@PathVariable("empFistName") String firstName) {
		return employeeService.searchEmployeeByFirstName(firstName);

	}

	@GetMapping("/sort")
	public List<Employee> getListOfEmployyesSortedByFirstName(Direction order) {
		return employeeService.getListOfEmployeesSortedByFirstName(order);

	}
//	@RequestMapping(value = "/403")
//	public ModelAndView accesssDenied(Principal user) {
//
//		ModelAndView model = new ModelAndView();
//
//		if (user != null) {
//			model.addObject("msg", "Hi " + user.getName() 
//			+ ", you do not have permission to access this page!");
//		} else {
//			model.addObject("msg", 
//			"You do not have permission to access this page!");
//		}
//
//		model.setViewName("403");
//		return model;
//	}

}
