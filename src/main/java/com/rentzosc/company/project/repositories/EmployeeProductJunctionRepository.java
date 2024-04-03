package com.rentzosc.company.project.repositories;

import com.rentzosc.company.project.entities.EmployeeProductJunction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeProductJunctionRepository extends JpaRepository<EmployeeProductJunction, Long> {
}
