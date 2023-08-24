package com.gl.bed.gradedProject4.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.bed.gradedProject4.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
