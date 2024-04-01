package com.rentzosc.company.project.repositories;

import com.rentzosc.company.project.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
